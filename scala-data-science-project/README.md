
## To build

`sbt assembly`

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
import com.fred.CustomFunction

CustomFunction(5)

```

## To plot

Load wisp

```
load.ivy("com.quantifind" %% "wisp" % "0.0.4")
```

Then

```
import com.quantifind.charts.Highcharts._
line((1 to 10), (1 to 10))
line(List(1, 2, 3, 4, 5), List(1, 2, 4, 8, 15))
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
