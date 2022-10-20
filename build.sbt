val projectName = "playground-playframework"

lazy val root: Project = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    organization := "com.example",
    name := projectName,
    version := "0.1",
    scalaVersion := "2.13.5",
    routesImport += "controllers.Implicits._",
    libraryDependencies ++= Seq(
      jdbc,
      "com.softwaremill.macwire" %% "macros" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "macrosakka" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "util" % "2.5.8",
      "com.softwaremill.macwire" %% "proxy" % "2.5.8",
    )
  )