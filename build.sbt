
import com.earldouglas.xwp.XwpPlugin
import play.twirl.sbt.SbtTwirl

name := "Spring-MVC-Twirl"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.2"

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

libraryDependencies ++= Seq(
	"org.springframework" % "spring-webmvc" % "4.0.6.RELEASE",
	"javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
	"com.google.guava" % "guava" % "17.0"
)

tomcat()
