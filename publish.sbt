publishMavenStyle := true

pomIncludeRepository := { _ => true }

sonatypeProfileName := "com.prince"
releaseIgnoreUntrackedFiles := true

sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
scmInfo := Some(
  ScmInfo(
    url("https://github.com/Prince951-17/bot4scala"),
    "scm:git:https://github.com/Prince951-17/bot4scala.git"
  )
)
pomExtra in Global := (
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>uz.scala</groupId>
    <artifactId>bot4scala</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
    <name>Telegram Bot API</name>
    <description>Telegram Bot API for scala</description>
    <url>https://github.com/Prince951-17/bot4scala</url>
    <licenses>
      <license>
        <name>Apache 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:Prince951-17/bot4scala.git</url>
      <connection>scm:git:git@github.com:Prince951-17/bot4scala.git</connection>
    </scm>
    <developers>
      <developer>
        <id>Prince</id>
        <name>Maftunbek Raxmatov</name>
        <url>https://github.com/Prince951-17</url>
      </developer>
    </developers>
    <distributionManagement>
      <snapshotRepository>
        <id>ossrh</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots</url>
      </snapshotRepository>
      <repository>
        <id>ossrh</id>
        <url>https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/</url>
      </repository>
    </distributionManagement>
    <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <build>
      <plugins>
        <plugin>
          <groupId>org.sonatype.plugins</groupId>
          <artifactId>nexus-staging-maven-plugin</artifactId>
          <version>1.6.7</version>
          <extensions>true</extensions>
          <configuration>
            <serverId>ossrh</serverId>
            <nexusUrl>https://s01.oss.sonatype.org/</nexusUrl>
            <autoReleaseAfterClose>true</autoReleaseAfterClose>
          </configuration>
        </plugin>
      </plugins>
    </build>
  </project>
  )