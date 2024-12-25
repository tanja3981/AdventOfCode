package de.tanschmi.kotlin.aoc2024.dec6

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
        println("Maze: $maze")

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