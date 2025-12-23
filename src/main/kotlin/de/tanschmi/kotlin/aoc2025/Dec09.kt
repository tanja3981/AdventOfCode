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

    fun step2(puzzleInput: String): Long {
        // Parse input: "x,y" → Pair(x, y)
        val corners: List<Pair<Long, Long>> = puzzleInput
            .lineSequence()
            .filter { it.isNotBlank() }
            .map { line ->
                val (x, y) = line.split(",").map { it.toLong() }
                x to y
            }
            .toList()

        val n = corners.size

        fun getSize(x1: Long, y1: Long, x2: Long, y2: Long): Long {
            val x = kotlin.math.abs(x1 - x2) + 1
            val y = kotlin.math.abs(y1 - y2) + 1
            return x * y
        }

        val edges = mutableListOf<List<Pair<Long, Long>>>()
        val sizes = mutableListOf<Triple<Long, Pair<Long, Long>, Pair<Long, Long>>>()

        // Build edges and rectangle candidates
        for (i in 0 until n) {
            // edges.append(sorted((corners[i], corners[i-1])))
            val prev = if (i == 0) corners[n - 1] else corners[i - 1]
            val edge = listOf(corners[i], prev)
                .sortedWith(compareBy({ it.first }, { it.second }))
            edges.add(edge)

            // sizes.append((get_size(*c1, *c2), c1, c2))
            for (j in i + 1 until n) {
                val (c1, c2) = listOf(corners[i], corners[j])
                    .sortedWith(compareBy({ it.first }, { it.second }))

                val size = getSize(c1.first, c1.second, c2.first, c2.second)
                sizes.add(Triple(size, c1, c2))
            }
        }

        // edges.sort(reverse=True, key=lambda e: get_size(*e[0], *e[1]))
        edges.sortByDescending { e ->
            getSize(
                e[0].first, e[0].second,
                e[1].first, e[1].second
            )
        }

        // sizes.sort(reverse=True)
        sizes.sortByDescending { it.first }

        // Find first rectangle without an edge inside
        for ((size, c1, c2) in sizes) {
            var (x1, y1) = c1
            var (x2, y2) = c2

            // y1, y2 = sorted((y1, y2))
            if (y1 > y2) {
                val tmp = y1
                y1 = y2
                y2 = tmp
            }

            val ok = edges.none { (p1, p2) ->
                val (x3, y3) = p1
                val (x4, y4) = p2

                (x4 > x1 && x3 < x2 && y4 > y1 && y3 < y2)
            }

            if (ok) return size
        }

        error("No rectangle found")
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