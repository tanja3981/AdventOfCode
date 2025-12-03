package de.tanschmi.kotlin.aoc2025.dec03

class Dec03Alternate2 {

    fun step1(lines: List<String>): Long { //unverändert
        var result = 0L
        for (line in lines) {
            result += findInLine(line)
        }
        return result
    }

    fun step2(lines: List<String>): Long {
        var result = 0L
        for (line in lines) {
            result += findInLine(line, 12)
        }
        return result
    }

    fun findInLine(line: String, n: Int = 2): Long {
        require(n in 0..<line.length)

        val stack = ArrayDeque<Char>()
        var toRemove = line.length - n

        //Greedy‑Stack‑Algorithmus
        //- Wir dürfen genau s.length-n Ziffern löschen (hier: 21 - 12 = 9).
        //- Wir laufen von links nach rechts durch den String.
        //- Wir benutzen einen Stack (eine Art Liste, in die man hinten Elemente einfügt und wieder entfernt).
        //- Wenn die aktuelle Ziffer größer ist als die letzte im Stack und wir noch löschen dürfen, entfernen wir die kleinere Ziffer.
        //- Danach fügen wir die aktuelle Ziffer hinten an.
        //- Am Ende kürzen wir den Stack auf genau n Ziffern.
        for (digit in line) {
            // solange wir noch löschen dürfen und die letzte Ziffer kleiner ist
            while (stack.isNotEmpty() && toRemove > 0 && stack.last() < digit) {
                stack.removeLast()
                toRemove--
            }
            stack.addLast(digit)
        }
        return stack.take(n).joinToString("").toLong()
    }
}