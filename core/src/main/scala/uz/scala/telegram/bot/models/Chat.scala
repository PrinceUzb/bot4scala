package uz.scala.telegram.bot.models

import uz.scala.telegram.bot.models.ChatType.ChatType

/**
 * This object represents a chat.
 *
 * @param id                       Integer Unique identifier for this chat, not exceeding 1e13 by absolute value
 * @param type                     String	Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * @param title                    String	Optional. Title, for supergroups, channels and group chats
 * @param username                 String	Optional. Username, for private chats, supergroups and channels if available
 * @param firstName               String Optional. First name of the other party in a private chat
 * @param lastName                String Optional. Last name of the other party in a private chat
 * @param photo                    ChatPhoto Optional. Chat photo. Returned only in getChat.
 * @param bio                      String Optional. Bio of the other party in a private chat. Returned only in getChat.
 * @param description              String	Optional. Description, for groups, supergroups and channel chats. Returned only in getChat.
 * @param inviteLink              String Optional. Primary invite link, for groups, supergroups and channel chats. Returned only in getChat.
 * @param pinnedMessage           Message Optional. The most recent pinned message (by sending date). Returned only in getChat.
 * @param permissions              ChatPermissions	Optional. Default chat member permissions, for groups and supergroups. Returned only in getChat.
 * @param slowModeDelay          Integer	Optional. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in getChat.
 * @param messageAutoDeleteTime Integer	Optional. The time after which all messages sent to the chat will be automatically deleted; in seconds. Returned only in getChat.
 * @param stickerSetName         String	Optional. For supergroups, name of group sticker set. Returned only in getChat.
 * @param canSetStickerSet      Boolean	Optional. True, if the bot can change the group sticker set. Returned only in getChat.
 * @param linkedChatId           Integer	Optional. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. Returned only in getChat.
 * @param location                 ChatLocation	Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
 */
case class Chat(
  id                   : Int,
  `type`               : ChatType,
  title                : Option[String] = None,
  username             : Option[String] = None,
  firstName            : Option[String] = None,
  lastName             : Option[String] = None,
  photo                : Option[ChatPhoto] = None,
  bio                  : Option[String] = None,
  description          : Option[String] = None,
  inviteLink           : Option[String] = None,
  pinnedMessage        : Option[Message] = None,
  permissions          : Option[ChatPermissions] = None,
  slowModeDelay        : Option[Int] = None,
  messageAutoDeleteTime: Option[Int] = None,
  stickerSetName       : Option[String] = None,
  canSetStickerSet     : Option[Boolean] = None,
  linkedChatId         : Option[Int] = None,
  location             : Option[ChatLocation] = None
)