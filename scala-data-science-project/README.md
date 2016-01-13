## Intro

This project provides a super-duper easy to use template Scala project **with jupyter notebook with Scala kernals**.  It uses docker to run the notebook so is a **single command** to install and run the notebook.  It includes examples of plotting, using libraries and using in progress code from the template Scala project.

## To build the scala code

`sbt assembly`

## To install/run the notebook

Ensure you have docker installed, recommend this documentation: https://github.com/docker/tutorials/tree/master/docs. 

To run the notebook `./start-notebook.sh`, it will spit out the URL.  If the docker container for the notebook does not yet exist, it will build it.

The docker uses your .ivy2 cache to find libraries, and also uses the `notebooks` directory to persist notebooks.  If you want to use a different directory to persist notebooks provide it as the first arguement to `start.sh-notebook.sh`.

## To stop the notebook

`./finish-notebook.sh`. Do NOT use kill -9, it puts the container into a very weird state.

## Examples

Start the notebook then open examples.ipynb

The examples include:

 - importing and using libs
 - importing and using your in progress Scala code under the Scala project
 - 2d plot
 - 3d plot

Some examples require commands to be run, please read the comments.




## To import libs into Scala notebook

```
load.ivy("org.scalanlp" %% "breeze" % "0.11.2")
```

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

## To plot 2D

Load wisp

```
load.ivy("com.quantifind" %% "wisp" % "0.0.4")
```

then in a new cell

```
import com.quantifind.charts.Highcharts._
line((1 to 10), (1 to 10))
line(List(1, 2, 3, 4, 5), List(1, 2, 4, 8, 15))
```

## To plot 3D

Unfortunately the only 3d plotting library I could find for Scala/Java is jzy3d which has a horrible old java uber verbose OOP style API and is rather unstable. An example is in `com.fred.ThreeDPlotExample`, and can be invoked as follows

load.ivy("org.jzy3d" % "jzy3d-api" % "0.9.2-SNAPSHOT")


```
load.jar("/home/sam/src/scala-build-files/scala-data-science-project/target/scala-2.10/fred-assembly-0.1.0.jar")
import com.fred.ThreeDPlotExample

ThreeDPlotExample()
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

1. update readme (use example python file instead of tick tick tick)
2. Try using Scala to generate javascript
3. Get dockerfile to work so one need not screw up python or depend on install-scala-jupyter - DONE
4. Get publish to work because load.jar doesn't seem to work
5. update readme

7. Determine if the OS has brew or apt-get, and automatically install docker.
