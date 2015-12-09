
## To build

`sbt assembly`

## To publish to maven repo

Use `publish-to-maven-repo.sh` script because `sbt` has a bug where it doesn't change the exit code on errors https://github.com/sbt/sbt/issues/2277

## Project Overview

It has

 - Spark
 - Scala 2.10 
 - Specs2
 - Scalacheck
 - aws-java-sdk
 - scallop
 - scalaz
 - spray-json
 - curly

and

 - fat jar plugin (sbt-assembly)
 - A simple shade rule for poms
 - very basic release (publish to a maven)
 - adds the fat jar as an artefact for release
 - some sbt plugins
 - an attempt at code coverage
