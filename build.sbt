name := "weather-simulator"

version := "1.0"

scalaVersion := "2.11.8"

mainClass in Compile := Some("com.prabhat.simulation.Simulator")

libraryDependencies ++= Seq(
  "com.typesafe"  %  "config" % "1.2.1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
    