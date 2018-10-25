version := "0.1.0"
scalaVersion := "2.12.7"
organization := "net.iatsuk"

lazy val bot = (project in file("."))
  .settings(
    name := "BlindGoBot",
    libraryDependencies += "junit" % "junit" % "4.12" % Test,
  )

