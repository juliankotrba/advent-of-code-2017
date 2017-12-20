import kotlin.math.abs

/**
 * Day twenty of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day20 {

    companion object {
        const val ITERATIONS = 1_000
    }

    fun calcPart1(input: List<MutableList<Long>>): Int {

        (0 until ITERATIONS).forEach { _ ->
            input.forEach { particle ->

                (8 downTo 3).forEach {
                    particle[it.minus(3)] = particle[it].plus(particle[it.minus(3)])
                }

            }
        }

        val distList = input.map { particle ->
                abs(particle[0]).plus(abs(particle[1])).plus(abs(particle[2]))
        }

        return distList.indexOf(distList.min())
    }

    fun calcPart2(input: MutableList<MutableList<Long>>): Int {

        (0 until ITERATIONS).forEach { _ ->


            val map = mutableMapOf<List<Long>, Int>()
            val removeSet = mutableSetOf<Int>()

            input.forEachIndexed { i, particle ->

                (8 downTo 3).forEach {
                    particle[it.minus(3)] = particle[it].plus(particle[it.minus(3)])
                }

                if (map.containsKey(particle.subList(0,3))) {
                    removeSet.add(i)
                    removeSet.add(map.getOrDefault(particle.subList(0,3), -5))
                } else {
                    map.put(particle.subList(0,3),i)
                }

            }

            removeSet.sorted().reversed().forEach {
                input.removeAt(it)
            }
        }

        println(input)

        return input.size
    }

}


