/**
 * Day thirteen of Advent of Code 2017
 * @author Julian Kotrba
 */

data class Area(val depth: Int, val range: Int)

class Day13 {

    fun calcPart1(input: List<Area>): Int {

        return input.filter {
            it.depth.rem((it.range.times(2)).minus(2)) == 0
        }.map {
            it.depth.times(it.range)
        }.sum()
    }

    fun calcPart2(input: List<Area>): Int {
        var delay = -1
        var isFound = false

        while (!isFound) {
            delay++

            isFound = walkAreasAndStopWhenCaught(input.size) { index ->
                input[index].depth.plus(delay).rem((input[index].range.times(2)).minus(2)) == 0
            }
        }

        return delay
    }

    private inline fun walkAreasAndStopWhenCaught(times: Int, caught: (Int) -> Boolean): Boolean {
        for (i in 0 until times) {
            if (caught(i)) {return false}
        }

        return true
    }
}


