/**
 * Day four of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day4 {

    fun calcPart1(input: List<List<String>>): Int {

        return input
                .filter { isValidP1(it) }
                .map { 1 }
                .sum()
    }

    fun calcPart2(input: List<List<String>>): Int {
        return input
                .filter { isValidP2(it) }
                .map { 1 }
                .sum()
    }

    private fun isValidP1(phrase: List<String>): Boolean {
        val phrases: MutableSet<String> = mutableSetOf()
        var isValid = true

        phrase.forEach {
            if (!phrases.add(it)) {
                isValid = false
                return@forEach
            }
        }

        return isValid
    }

    private fun isValidP2(phrase: List<String>): Boolean {
        val phrases: MutableSet<String> = mutableSetOf()
        var isValid = true

        phrase.forEach {
            val sortedString = String(it.toCharArray().sortedArray())
            if (!phrases.add(sortedString)) {
                isValid = false
                return@forEach
            }
        }

        return isValid
    }

}