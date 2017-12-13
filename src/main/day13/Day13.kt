/**
 * Day thirteen of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day13 {

    fun calcPart1(input: List<Int?>): Int {
        return input.mapIndexed { i, elem ->
            if (elem != null) {
                if (i.rem((elem * 2).minus(2)) == 0) {
                     i * elem
                } else 0
            } else 0
        }.sum()

    }

    fun calcPart2(input: List<Int?>): Int {
        var delay = 0
        var found = false

        while (!found) {
            found = true

            for (i in 0 until input.size) {
                val elem = input[i]
                val index = i+delay
                if(elem != null) {
                    if(index.rem((elem*2).minus(2)) == 0) {
                        found = false
                        break
                    }
                }
            }
            delay++
        }

        return --delay
    }
}


