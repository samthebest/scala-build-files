import ReleaseTransformations._

net.virtualvoid.sbt.graph.Plugin.graphSettings

val companyName = "fred"
val domain = "com"

// This part won't work without credentials on the machine
resolvers ++= Seq(
  "fred-libs" at "https://packages.fred/artifactory/libs-release",
  "fred-plugins" at "https://packages.fred/artifactory/plugins-release"
)

val sparkVersion = "1.5.1"
libraryDependencies ++= Seq(
  "com.fred" %% "data-containers" % "1.0.3",
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-core" % "2.4.15" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-scalacheck" % "2.4.15" % "test" withSources() withJavadoc(),

  "org.apache.spark" %% "spark-core" % sparkVersion % "provided" withSources() withJavadoc(),
  "com.amazonaws" % "aws-java-sdk" % "1.10.30" % "provided",

  "org.rogach" %% "scallop" % "0.9.5" withSources() withJavadoc(),
  "org.scalaz" %% "scalaz-core" % "7.1.4" withSources() withJavadoc(),
  "io.spray" %% "spray-json" % "1.3.2" withSources() withJavadoc(),
  // Using plain java, as scala version is messed up
  // (depends on java version AND includes all classes from java version, causing a conflict at fat-jar stage)
  "com.m3" % "curly" % "0.5.5" withSources() withJavadoc()
)

// json stuff breaks without this!
dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"
)

assemblyShadeRules in assembly := Seq(
  ShadeRule.zap("pom.xml").inAll
)

val projectName = "foo"

name := projectName

// Fat jar is the artefact
addArtifact(Artifact(projectName, "assembly"), sbtassembly.AssemblyKeys.assembly)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := Some(sys.props.get("publish.url").map(url => projectName at url)
                  .getOrElse(Resolver.file("Local ivy", Path.userHome / ".ivy2" / "local")))

// No other release steps since for this project everything else is handled by bash scripts (like version bumps, running tests, etc)
releaseProcess := Seq[ReleaseStep](
  publishArtifacts // : ReleaseStep, checks whether `publishTo` is properly set up
)

scalaVersion := "2.10.4"
// stop sbt arbitrarily choosing a different scala version - use the one we know Spark is using
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

scalacOptions ++= Seq("-feature", "-language:reflectiveCalls")

javaOptions ++= Seq("-target", "1.8", "-source", "1.8")

organization := domain + "." + companyName

parallelExecution in Test := false

// We were experimenting with getting code coverage to work, but couldn't
//jacoco.settings

version := "0.1.42"
