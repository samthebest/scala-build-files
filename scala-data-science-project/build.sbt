val companyName = "fred"
val domain = "com"

resolvers ++= Seq(
  "mvnrepository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "jzy3d-releases" at "http://maven.jzy3d.org/releases",
  "jzy3d-releases" at "http://maven.jzy3d.org/snapshots",
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-core" % "2.4.15" % "test" withSources() withJavadoc(),
  "org.specs2" %% "specs2-scalacheck" % "2.4.15" % "test" withSources() withJavadoc(),
  "org.scalanlp" %% "breeze" % "0.11.2" withSources() withJavadoc(),
  "org.scalanlp" %% "breeze-natives" % "0.11.2" withSources() withJavadoc(),
  "org.rogach" %% "scallop" % "0.9.5" withSources() withJavadoc(),
  "org.scalaz" %% "scalaz-core" % "7.1.4" withSources() withJavadoc(),
  "com.chuusai" %% "shapeless" % "2.2.5",
  "com.quantifind" %% "wisp" % "0.0.4",
  "io.continuum.bokeh" %% "bokeh" % "0.6",
  "org.jzy3d" % "jzy3d-api" % "0.9.2-SNAPSHOT",
  compilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full),
  ("org.apache.spark" % "spark-sql_2.10" % "1.5.0-cdh5.5.0") withSources() withJavadoc(),
  ("org.apache.spark" % "spark-core_2.10" % "1.5.0-cdh5.5.0") withSources() withJavadoc(),
  ("org.apache.spark" % "spark-mllib_2.10" % "1.5.0-cdh5.5.0") withSources() withJavadoc()
)

// Merge strat just uses first instead of error
mergeStrategy in assembly <<= (mergeStrategy in assembly)((old) => {
  case x if Assembly.isConfigFile(x) =>
    MergeStrategy.concat
  case PathList(ps@_*) if Assembly.isReadme(ps.last) || Assembly.isLicenseFile(ps.last) =>
    MergeStrategy.rename
  case PathList("META-INF", xs@_*) =>
    (xs map {
      _.toLowerCase
    }) match {
      case ("manifest.mf" :: Nil) | ("index.list" :: Nil) | ("dependencies" :: Nil) =>
        MergeStrategy.discard
      case ps@(x :: xs) if ps.last.endsWith(".sf") || ps.last.endsWith(".dsa") =>
        MergeStrategy.discard
      case "plexus" :: xs =>
        MergeStrategy.discard
      case "services" :: xs =>
        MergeStrategy.filterDistinctLines
      case ("spring.schemas" :: Nil) | ("spring.handlers" :: Nil) =>
        MergeStrategy.filterDistinctLines
      case _ => MergeStrategy.first // Changed deduplicate to first
    }
  case PathList(_*) => MergeStrategy.first // added this line
})

scalaVersion := "2.10.5"

javaOptions ++= Seq("-target", "1.8", "-source", "1.8")

organization := domain + "." + companyName

name := "fred"

parallelExecution in Test := false

version := "0.1.0"
