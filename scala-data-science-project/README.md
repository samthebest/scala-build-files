## Intro

This project provides a super-duper easy to use template Scala project **with jupyter notebook with Scala kernals** and **iScala**.  It uses docker to run the notebook so is a **single command** to install and run the notebook.  It includes examples of plotting, using libraries and using in progress code from the template Scala project.

## To build the scala code

`sbt assembly`

## To install/run the notebooks

Ensure you have docker installed, recommend this documentation: https://github.com/docker/tutorials/tree/master/docs. 

To run the notebook `./start-<notebook>.sh` where `<notebook>` can be either `jupyter` or `iscala`, it will spit out the URL.  If the docker container for the notebook does not yet exist, it will build it.

The docker uses your .ivy2 cache to find libraries, and also uses the `notebooks` directory to persist notebooks.  If you want to use a different directory to persist notebooks provide it as the first arguement to `start-<notebook>.sh`.

## To stop the notebook

Use docker or `./last-docker-stop.sh` if it was the last docker container you ran. Do NOT use kill -9, it puts the container into a very weird state.

## Examples

Example `.ipynb` showing the functionality for each notebook will already exist in the notebook dir.  They include things like plotting, importing libs, importing your code, etc.

## Jupyter Caveats

The jupyter notebook appears to have a number of issues, particularly in the display of images and such. Therefore the examples provided do not have any plotting.







## To run your code from your intellij project

First run

```
sbt package
```

Then in the notebook (for example based on my path)

```
load.jar("/home/sam/src/scala-build-files/scala-data-science-project/target/scala-2.10/fred_2.10-0.1.0.jar")
```

then in a new cell

```
import com.fred.CustomFunction

CustomFunction(5)

```

## Project Overview

It has

 - Spark 1.5.0-cdh5.5.1
 - Scala 2.10 
 - Specs2
 - Scalacheck
 - breeze (useful stats and NLP lib)
 - scallop
 - scalaz
 - shapeless
 - macros compiler plugin
 - wisp
 - bokeh

and

 - fat jar plugin (sbt-assembly)
 - some sbt plugins
 - changed merge strat to use first

# TODO

Consider just using iScala, since plotting is a pain (it doesn't show underneath)

1. Get publish to work because load.jar doesn't seem to work

2. update readme

3. Try using Scala to generate javascript

4. Determine if the OS has brew or apt-get, and automatically install docker.

Resources

https://jakevdp.github.io/blog/2013/06/01/ipython-notebook-javascript-python-communication/
