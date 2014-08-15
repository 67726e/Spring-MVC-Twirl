
import play.twirl.sbt.SbtTwirl

name := "Spring-MVC-Twirl"

organization := "us.hexcoder"

version := "1.0.0-SNAPSHOT"

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

// Additional POM information for releases
pomExtra :=
<licenses>
	<license>
		<name>MIT</name>
		<url>http://opensource.org/licenses/MIT</url>
	</license>
</licenses>
<developers>
	<developer>
		<name>Glenn Nelson</name>
		<email>glenn@hexcoder.us</email>
	</developer>
</developers>
<scm>
	<connection>scm:git:git@github.com:67726e/Spring-MVC-Twirl.git</connection>
	<developerConnection>scm:git:git@github.com:67726e/Spring-MVC-Twirl.git</developerConnection>
	<url>git@github.com:67726e/Spring-MVC-Twirl.git</url>
</scm>