
# To build

`sbt assembly`

# To publish to maven repo

Use `publish-to-maven-repo.sh` script because `sbt` has a bug where it doesn't change the exit code on errors https://github.com/sbt/sbt/issues/2277
