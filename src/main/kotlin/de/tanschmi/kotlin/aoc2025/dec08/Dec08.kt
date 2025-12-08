package de.tanschmi.kotlin.aoc2025.dec08

import java.util.*
import kotlin.math.pow

class Dec08 {

    fun step1(input: String, limit: Int): Int {
        val lines = input.lines()
        val allPoints = ArrayList<Point>()
        for (line in lines) {
            val parts = line.split(",")
            allPoints.add(Point(parts[0].toInt(), parts[1].toInt(), parts[2].toInt()))
        }
        val distances: TreeMap<Double, JunctionBox> = getDistances(allPoints)
        val circuits = ArrayList<HashSet<Point>>()

        var counter = 0
        while (counter < limit) {
            val key = distances.keys.first()
            val value: JunctionBox = distances.getValue(key)

            //bestehende circuits finden
            val c1 = circuits.find { it.contains(value.first) }
            val c2 = circuits.find { it.contains(value.sec) }

            when {
                c1 != null && c2 != null && c1 != c2 -> {
                    c1.addAll(c2)
                    circuits.remove(c2)
                }

                c1 != null -> c1.add(value.sec)
                c2 != null -> c2.add(value.first)
                else -> circuits.add(hashSetOf(value.first, value.sec)) //neues cluster
            }
            counter++
            distances.remove(key)
        }

        val top3 = circuits
            .sortedByDescending { it.size }
            .take(3)
        var sum = 1
        top3.forEach {
            sum *= it.size
        }

        return sum
    }

    fun step2(input: String): Long {
        val lines = input.lines()
        val allPoints = ArrayList<Point>()
        for (line in lines) {
            val parts = line.split(",")
            allPoints.add(Point(parts[0].toInt(), parts[1].toInt(), parts[2].toInt()))
        }
        val distances: TreeMap<Double, JunctionBox> = getDistances(allPoints)
        val circuits = ArrayList<HashSet<Point>>()

        distances.forEach { (key, value) ->
            //bestehende circuits finden
            val c1 = circuits.find { it.contains(value.first) }
            val c2 = circuits.find { it.contains(value.sec) }

            when {
                c1 != null && c2 != null && c1 != c2 -> {
                    c1.addAll(c2)
                    circuits.remove(c2)
                }

                c1 != null -> {
                    c1.add(value.sec)
                }

                c2 != null -> {
                    c2.add(value.first)
                }

                else -> {
                    //neues cluster
                    circuits.add(hashSetOf(value.first, value.sec))
                }
            }
            if (circuits[0].size == allPoints.size) {
                return value.first.x.toLong() * value.sec.x.toLong()
            }
        }
        return -1
    }

    fun getDistances(allPoints: ArrayList<Point>): TreeMap<Double, JunctionBox> {
        val distances = TreeMap<Double, JunctionBox>()
        allPoints.forEach { point ->
            allPoints.forEach {
                if (it != point) {
                    val d = distance(point, it)
                    distances[d] = JunctionBox(it, point)
                }
            }
        }
        return distances
    }

    fun distance(a: Point, b: Point): Double {
        return kotlin.math.sqrt(
            (b.x - a.x).toDouble().pow(2) +
                    (b.y - a.y).toDouble().pow(2) +
                    (b.z - a.z).toDouble().pow(2)
        )
    }
}

data class Point(val x: Int, val y: Int, val z: Int)

data class JunctionBox(val first: Point, val sec: Point)