package de.tanschmi.kotlin.aoc2023.dec04

import java.util.*

class Dec04 {

    fun step1(input: String): Long {

        val lines = input.lines()

        var sum = 0L
        for(line in lines) {
            sum += parseLineForStep1(line)
        }
        return sum
    }

    fun parseLineForStep1(line: String): Int {
        val regex = Regex("\\s+")

        val parts = line.split(":", "|")
        val leftPart = parts[1].trim()
        val rightPart = parts[2].trim()
        val winning: List<Int> = leftPart
            .split(regex)
            .map { it.trim().toInt() }
        val numbers: List<Int> = rightPart
            .split(regex)
            .map { it.trim().toInt() }

        var points = 0
        for (no in numbers) {

            if(winning.contains(no)) {
                if(points == 0) {
                    points += 1
                } else {
                    points *= 2
                }
            }
        }
        return points
    }

    fun step2(input: String): Int {

        val lines = input.lines()
        val cards: LinkedList<String> = LinkedList<String>()

        cards.addAll(input.lines())
        val processedCards = ArrayList<String>()

        while (cards.isNotEmpty()) {
            parseLineStep2( cards, lines, processedCards)
        }

        return processedCards.size

    }

    fun parseLineStep2(cards: LinkedList<String>, origLines: List<String>, processedCards: MutableList<String>) {
        val line = cards.first()
        val regex = Regex("\\s+")
        val parts = line.split(":", "|")
        val cardNo = parts[0].substring("Card".length).trim().toInt()
        val leftPart = parts[1].trim()
        val rightPart = parts[2].trim()
        val winning: List<Int> = leftPart
            .split(regex)
            .map { it.trim().toInt() }
        val numbers: List<Int> = rightPart
            .split(regex)
            .map { it.trim().toInt() }

        var matches = 0
        for (no in numbers) {
            if (winning.contains(no)) {
                matches++
            }
        }
        if (matches > 0) {
            for (n in cardNo ..<cardNo + matches) {
                if (n < origLines.size) {
                    cards.add( "" + origLines[n])
                }
            }
        }
        processedCards.add(line)
        cards.removeFirst()
    }
}