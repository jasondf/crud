name := """crud"""
organization := "com.wmdit"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.43"

libraryDependencies ++= Seq(
  guice,
  evolutions,
  jdbc,
  ws,
  ehcache,
  javaJdbc
)

libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "2.1.0" % Test
testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")

// Only enhance java sources in models
sources in (Compile, playEnhancerGenerateAccessors) := {
  ((javaSource in Compile).value / "models" ** "*.java").get
}

// Only display errors
ivyLoggingLevel := UpdateLogging.Quiet

// Enable debug, with -1 being off, and 9 showing the most amount of debug:
playEbeanDebugLevel := 4

