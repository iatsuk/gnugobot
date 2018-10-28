version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.7"
organization := "net.iatsuk"

lazy val bot = (project in file("."))
  .settings(
    name := "GnuGoBot",
    libraryDependencies += "info.mukel" %% "telegrambot4s" % "3.0.16",
    libraryDependencies += "junit" % "junit" % "4.12" % Test,
  )

