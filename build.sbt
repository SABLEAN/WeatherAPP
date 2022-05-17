val root = project
  .in(file("."))
  .settings(
    name := "WeatherAPP",
    version := "0.1",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Dependencies.all
  )