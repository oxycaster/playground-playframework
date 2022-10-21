// resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"


// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.16") // where version is the current Play version, i.e. "2.8.x"

// Database migration
// https://github.com/flyway/flyway-sbt
addSbtPlugin("io.github.davidmweber" % "flyway-sbt" % "7.4.0")

// Slick code generation
// https://github.com/tototoshi/sbt-slick-codegen
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.47"
addSbtPlugin("com.github.tototoshi" % "sbt-slick-codegen" % "1.4.0")