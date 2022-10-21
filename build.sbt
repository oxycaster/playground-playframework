import _root_.slick.codegen.SourceCodeGenerator
import _root_.slick.{model => m}

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
    scalaVersion := "2.13.10",
    routesImport += "controllers.Implicits._",
    libraryDependencies ++= Seq(
      jdbc,
      "com.softwaremill.macwire" %% "macros" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "macrosakka" % "2.5.8" % Provided,
      "com.softwaremill.macwire" %% "util" % "2.5.8",
      "com.softwaremill.macwire" %% "proxy" % "2.5.8",

      "com.typesafe.play" %% "play-slick" % "5.1.0",
    )
  ).dependsOn(slick).aggregate(slick)

lazy val flyway = (project in file("modules/flyway"))
  .enablePlugins(FlywayPlugin)
  .settings(
    scalaVersion := "2.13.10",
    flywayUrl := databaseUrl,
    flywayUser := databaseUser,
    flywayPassword := databasePassword,
    flywayLocations += "db/migration",
    libraryDependencies ++= Seq(
      "mysql" % "mysql-connector-java" % "5.1.47",
    )
  )

lazy val slick = (project in file("modules/slick"))
  .enablePlugins(CodegenPlugin)
  .settings(
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      "com.zaxxer" % "HikariCP" % "3.4.2",

      "com.typesafe.slick" %% "slick" % "3.4.1",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.4.1",
    ),

    slickCodegenDatabaseUrl := databaseUrl,
    slickCodegenDatabaseUser := databaseUser,
    slickCodegenDatabasePassword := databasePassword,
    slickCodegenDriver := _root_.slick.jdbc.MySQLProfile,
    slickCodegenJdbcDriver := "com.mysql.jdbc.Driver",
    slickCodegenOutputPackage := "slick",
    slickCodegenExcludedTables := Seq("flyway_schema_history"),

    slickCodegenCodeGenerator := { (model: m.Model) => new SourceCodeGenerator(model) },
    (Compile / sourceGenerators) += slickCodegen.taskValue
  )