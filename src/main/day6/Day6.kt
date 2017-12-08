/**
 * Day six of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day6 {

    fun calcPart1(input: MutableList<Int>): Int {

        val resultSet = mutableSetOf<List<Int>>()
        var steps = 0

        while(resultSet.add(input)) {

            var (index, maxVal) = findMaxWithIndex(input)
            input[index] = 0
            index++

            while(maxVal > 0) {
                index = if(index>=input.size) 0 else index

                input[index] += 1

                index++
                maxVal--
            }
            steps++
        }

        return steps
    }

    /**
     * Optimized solution for part 1
     */
    fun calcPart1Optimized(input: MutableList<Int>): Int {

        val resultSet = mutableSetOf<List<Int>>()
        var steps = 0

        while(resultSet.add(input)) {

            val (index, maxVal) = findMaxWithIndex(input)
            input[index] = 0

            val divVal = maxVal.div(input.size)
            val modVal = maxVal.rem(input.size)

            for (i in 0 until input.size) {
                input[i] += divVal
            }

            for (i in 1 .. modVal ) {
                val j = if ((index + i) >= input.size) (index+i).minus(input.size) else i+index
                input[j] += 1
            }

            steps++
        }

        return steps
    }

    fun calcPart2(input: MutableList<Int>): Int {

        // set input to found circle
        this.calcPart1Optimized(input)

        val resultSet = mutableSetOf(input)
        var steps = 0

        do {
            val (index, maxVal) = findMaxWithIndex(input)
            input[index] = 0

            val divVal = maxVal.div(input.size)
            val modVal = maxVal.rem(input.size)

            for (i in 0 until input.size) {
                input[i] += divVal
            }

            for (i in 1 .. modVal ) {
                val j = if ((index + i) >= input.size) (index+i).minus(input.size) else i+index
                input[j] += 1
            }
            steps++
        } while(!resultSet.contains(input))

        return steps
    }

    private fun findMaxWithIndex(banks: List<Int>): Pair<Int, Int> {
        var index = 0
        var value = -1

        banks.forEachIndexed{ i, v ->
            if(v>value) {
                value = v
                index = i
            }
        }

        return Pair(index, value)
    }

}