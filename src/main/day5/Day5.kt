/**
 * Day five of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day5 {

    fun calcPart1(input: MutableList<Int>): Int {
        var pos = 0
        var jumps = 0

        while (pos < input.size) {
            val curr = input[pos]

            input[pos] += 1
            pos += curr
            jumps++
        }

        return jumps
    }

    fun calcPart2(input: MutableList<Int>): Int {
        var pos = 0
        var jumps = 0

        while (pos < input.size) {
            val curr = input[pos]

            when (curr >=3) {
                true -> input[pos] -= 1
                false -> input[pos] += 1
            }

            pos += curr
            jumps++
        }

        return jumps
    }

}