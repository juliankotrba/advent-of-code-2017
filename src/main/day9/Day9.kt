/**
 * Day nine of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day9 {

    fun calcPart1(input: String): Int {
        var groupCount = 0
        var score = 0
        var ignoreNext = false
        var isGarbage = false

        input.forEach { c ->

            if (c == '!' && !ignoreNext) {
                ignoreNext = true
                return@forEach
            }

            if (!ignoreNext) {

                when {
                    c == '{' && !isGarbage -> score++
                    c == '}' && !isGarbage -> { groupCount += score; score-- }
                    c == '<' -> isGarbage = true
                    c == '>' -> isGarbage = false
                }

            } else {
                ignoreNext = false
            }
        }

        return groupCount
    }

    fun calcPart2(input: String): Int {
        var groupCount = 0
        var score = 0
        var ignoreNext = false
        var isGarbage = false
        var garbageCount = 0

        input.forEach { c ->

            if (c == '!' && !ignoreNext) {
                ignoreNext = true
                return@forEach
            }

            if (!ignoreNext) {

                when {
                    c == '{' && !isGarbage -> score++
                    c == '}' && !isGarbage -> { groupCount += score; score-- }
                    c == '<' && !isGarbage -> isGarbage = true
                    c == '>' -> isGarbage = false
                    isGarbage -> garbageCount++
                }

            } else {
                ignoreNext = false
            }
        }

        return garbageCount
    }

}


