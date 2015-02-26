lazy val root = (project in file(".")).
  settings(
    name := "hello",
    version := "1.0",
    scalaVersion := "2.11.4"
  )

libraryDependencies += "org.scaldi" %% "scaldi" % "0.5.4"

