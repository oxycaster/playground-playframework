val projectName = "playground-playframework"

lazy val databaseUrl = sys.env.getOrElse("JDBC_DATABASE_URL", "")
lazy val databaseUser = sys.env.getOrElse("JDBC_DATABASE_USERNAME", "")
lazy val databasePassword = sys.env.getOrElse("JDBC_DATABASE_PASSWORD", "")

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

lazy val flyway = (project in file("modules/flyway"))
  .enablePlugins(FlywayPlugin)
  .settings(
    scalaVersion := "2.13.5",
    flywayUrl := databaseUrl,
    flywayUser := databaseUser,
    flywayPassword := databasePassword,
    flywayLocations += "db/migration",
    libraryDependencies ++= Seq(
      "mysql" % "mysql-connector-java" % "5.1.47",
    )
  )