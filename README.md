# PROJECT IN PAUSE MODE

It seems typesafe have this thing which makes this project unnecessary https://www.typesafe.com/community/core-tools/activator-and-sbt.


# scala-build-files

A collection of templates / boiler plates build / project files / structures for quickly getting a Scala project up and running with various libraries. It is build tool agnostic, any example may exist.

# Ambition

To remove the rather epic barrier to entry Scala has regarding the complexity of getting build files to work.  Together we can make Scala the go to language for a wider variety of projects.

We wish for everyone and anyone to take the build file for their company, remove the code, IP and company name, and commit it to this project.  Imagine how awesomely easy it would be for people to get into Scala if just one person from each company did this!

## Why a single repo? What's wrong with github?

It would be nice to see everything in one place, have a README.md for each, easier Googlability and have all project specific code removed.  Furthermore having everything in a single project could mean in a single clone one can grep through all the templates, (or use some other search tool easily).

# Use

To use any of the examples just:

1. Clone the repo
2. Move the example you want into where you keep your projects (optional: and delete the rest)
3. (Suggested) Ensure Intellij is installed and has the Scala plugin installed, then click "File > open" and find the build file - double clicking on the build file should mean intellij magically downloads the dependencies and sets everything up.

TODO Step by step tutorial with screen shots and for multiple IDEs.

# Template Structure

Each example/template/boiler-plate should be contained in a top level directory that loosely describes what libraries or plugins it uses, e.g. "sbt-spark-scalaz-shapeless", or "mvn-macros-spray", or "mvn-spray-akka-with-release-process", or "sbt-parboiled-with-fat-jar", or "gradle-breeze-with-sbt-pack".

## Required

The project should have:

 - The correct directory structure in place, e.g. src/main/scala/com/yourcompany-changeme, src/test/scala/com/yourcompany-changeme project/, target/.  Placeholder files may be necessary if no example code exists.
 - A .gitignore to ensure IDE files and compiled code won't get added
 - The build file itself, together with any plugin files and other configs
 - *IMPORTANT*: A README.md that breifly describes (A) what libraries the project has, what extras it has (code coverage, release process etc) and (B) what the command line is to build it and run tests

## Desired but not required

Example code that uses the libraries to prove it does actually build in a non-trivial way.

# TOP WANTED TEMPLATES

 - Template projects using visualisation tools, with simple examples of plotting (2D TSV, 3D TSV).
 - Template projects with a script that starts iScala/iSpark/Zeppelin that *uses the build file* to determine dependencies.
