package com.fred

import java.io.File

import org.jzy3d.chart.{ChartLauncher, Chart}
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.maths.Coord3d
import org.jzy3d.plot3d.primitives.{Shape, Point, Polygon}
import scala.collection.JavaConverters._

object ThreeDPlotExample extends (() => Unit) {
  def apply(): Unit = {
    val distDataProp = List(List(0.25, 0.45, 0.20), List(0.56, 0.89, 0.45), List(0.6, 0.3, 0.7))

    val polygons: java.util.List[Polygon] = distDataProp.indices.dropRight(1).flatMap(i =>
      distDataProp(i).indices.dropRight(1).map(j => {
        val polygon = new Polygon()
        polygon.add(new Point(new Coord3d(i, j, distDataProp(i)(j))))
        polygon.add(new Point(new Coord3d(i, j + 1, distDataProp(i)(j + 1))))
        polygon.add(new Point(new Coord3d(i + 1, j + 1, distDataProp(i + 1)(j + 1))))
        polygon.add(new Point(new Coord3d(i + 1, j, distDataProp(i + 1)(j))))
        polygon
      })).toList.asJava

    val surface: Shape = new Shape(polygons)

    surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds.getZmin, surface.getBounds.getZmax,
      new org.jzy3d.colors.Color(1, 1, 1, 1f)))

    surface.setWireframeDisplayed(true)
    surface.setWireframeColor(org.jzy3d.colors.Color.BLACK)
    val chart = new Chart()
    chart.getScene.getGraph.add(surface)
//    ChartLauncher.openChart(chart)

    // Doesn't work
    ChartLauncher.screenshot(chart, "/tmp/image")

  }
}
