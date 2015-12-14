
val companyName = "fred"
val domain = "com"

val mavenRepo: String = "maven." + companyName + "." + domain

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io"
)

val akkaV = "2.3.6"
val sprayV = "1.3.2"

libraryDependencies ++= Seq(
  "org.parboiled" %% "parboiled" % "2.0.1" withSources() withJavadoc(),
  //
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-core" % "2.4.15" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-scalacheck" % "2.4.15" % "test" withSources() withJavadoc(),
  "org.scalaz" %% "scalaz-core" % "7.1.0" withSources() withJavadoc(),
  //
  "org.apache.commons" % "commons-math3" % "3.2" withSources() withJavadoc(),
  "org.apache.commons" % "commons-lang3" % "3.3.2" withSources() withJavadoc(),
  "com.googlecode.java-diff-utils" % "diffutils" % "1.2",
  //
  "com.google.api-client" % "google-api-client" % "1.19.1" withSources() withJavadoc(),
  "com.google.code.gson" % "gson" % "2.3.1" withSources() withJavadoc(),
  "com.google.http-client" % "google-http-client-jackson" % "1.19.0" withSources() withJavadoc(),
  "com.google.oauth-client" % "google-oauth-client-java6" % "1.19.0" withSources() withJavadoc(),
  //
  "io.spray" %% "spray-json" % "1.3.1" withSources() withJavadoc(),
  "io.spray" %% "spray-can" % sprayV withSources() withJavadoc(),
  // Cannot use spray-routing with parboiled, must use spray-routing-shapeless2
  //"io.spray" %% "spray-routing" % sprayV withSources() withJavadoc(),
  "io.spray" %% "spray-routing-shapeless2" % sprayV withSources() withJavadoc(),
  "io.spray" %% "spray-testkit" % sprayV  % "test" withSources() withJavadoc(),
  //
  "com.typesafe.akka" %% "akka-actor" % akkaV withSources() withJavadoc(),
  "com.typesafe.akka" %% "akka-testkit" % akkaV % "test" withSources() withJavadoc(),
  //
  "org.rogach" %% "scallop" % "0.9.5" withSources() withJavadoc()
)

scalaVersion := "2.11.4"

javaOptions ++= Seq("-target", "1.8", "-source", "1.8")

organization := domain + "." + companyName

name := "fred"

parallelExecution in Test := false

version := "0.1.0"