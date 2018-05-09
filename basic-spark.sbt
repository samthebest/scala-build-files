val companyName = "fred"
val domain = "com"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

val sparkVersion = "2.2.0"

libraryDependencies ++= Seq(
  ("org.apache.spark" %% "spark-sql" % sparkVersion) withSources() withJavadoc(),
  ("org.apache.spark" %% "spark-core" % sparkVersion) withSources() withJavadoc(),
  ("org.apache.spark" %% "spark-mllib" % sparkVersion) withSources() withJavadoc()
)

scalaVersion := "2.11.8"

javaOptions ++= Seq("-target", "1.8", "-source", "1.8")

organization := domain + "." + companyName

name := "fred"

parallelExecution in Test := false

version := "0.1.0"
