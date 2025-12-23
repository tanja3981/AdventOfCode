package de.tanschmi.kotlin.aoc2025

import java.util.*
import kotlin.math.abs

class Dec09 {

    fun step1(input: String): Long {
        val list = parseInput(input)

        val distances = HashMap<Long, Pair<Point, Point>>()
        list.forEach { point ->
            list.forEach {
                if (it != point) {
                    val dx = abs(it.x - point.x) + 1
                    val dy = abs(it.y - point.y) + 1
                    val dist: Long = dx * dy
                    distances[dist] = Pair(point, it)
                }
            }
        }
        val max = distances.maxBy { it.key }.key
        return max
    }

    fun step2(input: String): Long {

        return 0L
    }

    fun parseInput(input: String): MutableList<Point> {
        val list = ArrayList<Point>()
        for (line in input.lines()) {
            if (line.isEmpty())
                continue
            val parts = line.split(",")
            list.add(Point(parts[0].toLong(), parts[1].toLong()))
        }
        return list
    }

    data class Point(val y: Long, val x: Long)
    data class Border(val a: Point, val b: Point)
    data class Rectangle(val area: Long, val x: Int, val y: Int)
}