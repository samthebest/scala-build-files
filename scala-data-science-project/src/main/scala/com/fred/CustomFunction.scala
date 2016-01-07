package com.fred

object CustomFunction extends (Int => Int) {
  def apply(i: Int): Int = i * 5 + 1
}
