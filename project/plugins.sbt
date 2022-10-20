// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.18") // where version is the current Play version, i.e. "2.8.x"

// Database migration
// https://github.com/flyway/flyway-sbt
addSbtPlugin("io.github.davidmweber" % "flyway-sbt" % "7.4.0")