/**
 * Day seventeen of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day17 {

    companion object {
        const val ITERATIONS_P1 = 2018
        const val ITERATIONS_P2 = 50_000_000
    }

    fun calcPart1(step: Int): Int {

        val buffer= mutableListOf(0)

        var pos = 0
        var value = 1
        (1 until ITERATIONS_P1).forEach {

            pos = (((pos.plus(step)).rem(buffer.size)).plus(1))
            buffer.add(pos, value)

            value++
        }

        return buffer[pos.plus(1)]
    }

    fun calcPart2(step: Int): Int {
        var pos = 0
        var value = 1
        var size = 1
        var posOfZero = 0
        var valueAfterZero = 1

        (1 until ITERATIONS_P2).forEach {

            pos = (((pos.plus(step)).rem(size)).plus(1))

            if (pos == posOfZero.plus(1)) {
                valueAfterZero = it
            }

            if (pos == posOfZero) {
                posOfZero++
            }

            value++
            size++
        }

        return valueAfterZero
    }

}


