

TODO

1. Remove jzy3d it sucks
2. Try using Scala to generate javascript
3. Get dockerfile to work so one need not screw up python or depend on install-scala-jupyter - DONE
4. Get publish to work because load.jar doesn't seem to work
5. update readme

## To build

`sbt assembly`

## To install/run the notebook

Install (only works on debian linux, not done one for mac yet)

```
./install-scala-jupyter.sh
```

Run

```
ipython3 notebook
```


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

# WARNING

jupyter is a bit weird, if you ever move your source tree it breaks the notebook, you have to edit the JSON config files in ~/.ipython/kernals
