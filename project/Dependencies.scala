import sbt._

object Dependencies {

  val versionCatsCore = "2.7.0"
  val versionCatsEffect = "3.3.0"
  val versionTapir = "0.19.1"
  val catsCore = "org.typelevel" %% "cats-core" % versionCatsCore
  val catsEffect = "org.typelevel" %% "cats-effect" % versionCatsEffect
  val tapirCore = "com.softwaremill.sttp.tapir" %% "tapir-core" % versionTapir
  val tapirJsonCirce = "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % versionTapir
  val tapirHttp4sServer = "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % versionTapir
  val tapir = "com.softwaremill.sttp.tapir" %% "tapir-sttp-client" % versionTapir
  val b = "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % "3.3.0"


  val all = Seq(catsCore,catsEffect,tapirCore,tapirJsonCirce,tapirHttp4sServer,tapir,b)
}
