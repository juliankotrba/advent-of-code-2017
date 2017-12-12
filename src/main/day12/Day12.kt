/**
 * Day twelve of Advent of Code 2017
 * 
 * really slow solution but I got my two stars ..
 * 
 * @author Julian Kotrba
 */

class Day12 {

    fun calcPart1(input: List<String>): Int {
        val connected = mutableSetOf(0)
        dfs(connected, input, 0)

        return connected.size
    }

    fun calcPart2(input: List<String>): Int {
        var groupCount = 0

        val groupedProgs = mutableSetOf<Int>()

        input.forEach {
            if (!groupedProgs.contains(Integer.valueOf(it.split("<->")[0].trim()))) {
                val connected = mutableSetOf(0)
                dfs(connected, input, Integer.valueOf(it.split("<->")[0].trim()))
                groupCount++

                groupedProgs.addAll(connected)
            }
        }

        return groupCount
    }

    private fun dfs(connected: MutableSet<Int>, input: List<String>, curr: Int) {

        input.filter {
            Integer.parseInt(it.split("<->")[0].trim()) == curr
        }.forEach {
            val neighbours = it.split("<->")[1].split(",")

            neighbours.forEach { num ->
                if (!connected.contains(Integer.parseInt(num.trim()))) {
                    connected.add(Integer.parseInt(num.trim()))
                    dfs(connected, input, Integer.parseInt(num.trim()))
                }
            }
        }

    }

}


