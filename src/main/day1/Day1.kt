/**
 * Day one, part 2 of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day1 {

    fun calc(input: List<Int>): Int {
        val step = input.size.div(2)

        return input.filterIndexed { i, v ->
            v == input[compIndex(i, input.size, step)]
        }.sum()
    }

    private fun compIndex(currentIndex: Int, listSize: Int, step: Int): Int {
        return when {
            currentIndex.plus(step) >= listSize -> currentIndex.plus(step).minus(listSize)
            else -> currentIndex.plus(step)
        }
    }

}