
import play.twirl.sbt.SbtTwirl

name := "Spring-MVC-Twirl"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.2"

sbtVersion := "0.13.5"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

libraryDependencies ++= Seq(
	"org.springframework" % "spring-webmvc" % "4.0.6.RELEASE",
	"com.typesafe.play" % "twirl-api_2.11" % "1.0.2",
	"javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
	"com.google.guava" % "guava" % "17.0"
)

// Test dependencies
libraryDependencies ++= Seq(
	"junit" % "junit" % "4.11" % Test,
	"org.scalatest" % "scalatest_2.11" % "2.2.1" % Test,
	"org.mockito" % "mockito-core" % "1.9.5" % Test,
	"org.hamcrest" % "hamcrest-all" % "1.3" % Test,
	"org.springframework" % "spring-test" % "4.0.6.RELEASE" % Test
)
