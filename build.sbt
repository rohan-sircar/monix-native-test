import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .enablePlugins(NativeImagePlugin)
  .settings(
    name := "monix-graalvm-native",
    Compile / mainClass := Some("example.MonixHello"),
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "io.monix" %% "monix" % "3.2.2",
    nativeImageOptions ++= Seq("--no-fallback"),
  )
