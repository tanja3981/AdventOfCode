package de.tanschmi.kotlin.aoc2024.dec6

import de.tanschmi.kotlin.aoc2024.deepClone
import lombok.extern.slf4j.Slf4j

const val UP = 0
const val RIGHT = 1
const val DOWN = 2
const val LEFT = 3

@Slf4j
class Dec6 {

    fun task1(input: String): Int {
        var maze: Array<CharArray> = input.lines()
            .filter { it.isNotBlank() }
            .map { it.toCharArray() }
            .toTypedArray()

        var current: Int = findStart(maze)
        var direction: Int = UP

        var steps: HashSet<Int> = HashSet()
        steps.add(current)

        while (true) {
            var next = nextStep(current, direction)
            if (!checkRange(maze, next)) {
                break
            }
            if (checkObstacle(maze, next)) {
                direction = (direction + 1) % 4
                continue
            }
            current = next
            maze[current / 1000][current % 1000] = 'X'
            steps.add(current)
        }
        return steps.size
    }

    fun task2(input: String): Int {
        var maze: Array<CharArray> = input.lines()
            .filter { it.isNotBlank() }
            .map { it.toCharArray() }
            .toTypedArray()
        println("Maze: $maze")

        val current: Int = findStart(maze)
        var steps: HashMap<Int, ArrayList<Int>> = HashMap()
        solveMaze(maze, current, steps)
        var obstacles = 0

        for (possObstacle in steps.keys) {
            var m = deepClone(maze)
            m[possObstacle / 1000][possObstacle % 1000] = '0'

            if (solveMaze(m, current, HashMap())) {
                obstacles++
            }
        }
        return obstacles
    }


    fun solveMaze(maze: Array<CharArray>, start: Int, steps: HashMap<Int, ArrayList<Int>>): Boolean {
        var current: Int = start
        var direction: Int = UP
        while (true) {


            var next = nextStep(current, direction)

            if (!checkRange(maze, next)) {
                return false
            }
            if (checkObstacle(maze, next)) {
                direction = (direction + 1) % 4
                continue
            }
            current = next
            //maze[current / 1000][current % 1000] = 'X'

            //check loop
            var v: ArrayList<Int>? = steps.get(current);
            if (v == null) {
                v = ArrayList()
            }
            if (v.contains(direction)) {
                return true
            }
            v.add(direction)
            steps.put(current, v)
        }
    }

    fun checkObstacle(maze: Array<CharArray>, position: Int): Boolean {
        var pos = maze[position / 1000][position % 1000]
        return pos == '#' || pos == '0'
    }

    fun checkRange(maze: Array<CharArray>, position: Int): Boolean {
        var row = position / 1000
        var col = position % 1000
        return !(row < 0 || row >= maze.size
                || col < 0 || col >= maze[0].size)
    }

    fun nextStep(position: Int, direction: Int): Int {

        when (direction) {
            UP -> return position - 1000
            DOWN -> return position + 1000
            LEFT -> return position - 1
            RIGHT -> return position + 1
        }
        return -1
    }

    fun findStart(maze: Array<CharArray>): Int {

        for (rowIndex in maze.indices) {
            for (colIndex in maze[rowIndex].indices) {
                if (maze[rowIndex][colIndex] == '^') {
                    return rowIndex * 1000 + colIndex
                }
            }
        }
        return -1
    }
}