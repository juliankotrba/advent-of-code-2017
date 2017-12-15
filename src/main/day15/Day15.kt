import kotlin.coroutines.experimental.buildSequence

/**
 * Day fifteen of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day15 {

    fun calcPart1(gA: Generator, gB: Generator): Int {

        var matches = 0

        (0 until 40_000_000).forEach {
            val g1 = (gA.prev.times(gA.factor)).rem(2147483647)
            gA.prev = g1

            val g2 = (gB.prev.times(gB.factor)).rem(2147483647)
            gB.prev = g2

            if (g1 and 0xFFFF == g2 and 0xFFFF) {
                matches++
            }
        }

        return matches
    }

    fun calcPart2(gA: Generator, gB: Generator): Int {

        val valuesA: List<Long> = calc(gA, 4).toList()
        val valuesB: List<Long> = calc(gB, 8).toList()

        return valuesA.zip(valuesB)
                .filter { it.first.and(0xFFFF) == it.second.and(0xFFFF) }
                .map { 1 }
                .sum()
    }

    private fun calc(generator: Generator, divider: Long) = buildSequence {
        var count = 0L
        while (count <= 5_000_000) {
            val value = (generator.prev.times(generator.factor)).rem(2147483647)
            generator.prev = value
            if (value.rem(divider) == 0L) {
                yield(value)
                count++
            }
        }
    }

}

data class Generator(var prev: Long, val factor: Long)


