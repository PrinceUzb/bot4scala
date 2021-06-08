package api

import cats.MonadError
import cats.syntax.flatMap._
import cats.syntax.functor._
import cats.syntax.monadError._
import com.typesafe.scalalogging.StrictLogging
import io.circe.{Decoder, Encoder}
import uz.scala.telegram.bot.methods.{GetUpdates, Request, Response}

import java.util.UUID

abstract class RequestHandler[F[_]](implicit monadError: MonadError[F, Throwable]) extends StrictLogging {

  def sendRequest[R, T <: Request[_ /* R */ ]](request: T)(implicit encT: Encoder[T], decR: Decoder[R]): F[R]

  /**
   * Spawns a type-safe request.
   *
   * @param request
   * @tparam R Request's expected result type
   * @return The request result wrapped in a Future (async)
   */
  def apply[R](request: Request[R]): F[R] =
    for {
      uuid <- monadError.pure {
                val uuid = UUID.randomUUID()
                logger.trace("REQUEST {} {}", uuid, request)
                uuid
              }
      result <- monadError
                  .attempt(sendRequestInternal(request))
                  .flatTap({
                    case Right(response) =>
                      monadError.pure(logger.trace("RESPONSE {} {}", uuid, response))
                    case Left(e) =>
                      monadError.pure(logger.error("RESPONSE {} {}", uuid, e))
                  })
                  .rethrow
    } yield result

  private def sendRequestInternal[R](request: Request[R]): F[R] =
    request match {
      // Pure JSON requests
      case s: GetUpdates                      => sendRequest[R, GetUpdates](s)
    }

  protected def processApiResponse[R](response: Response[R]): R = response match {
    case Response(true, Some(result), _, _, _) => result
    case Response(false, _, description, Some(errorCode), parameters) =>
      throw TelegramApiException(
        description.getOrElse("Unexpected/invalid/empty response"),
        errorCode,
        None,
        parameters
      )

    case other =>
      throw new RuntimeException(s"Unexpected API response: $other")
  }
}
