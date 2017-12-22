/**
 * Day twenty-one of Advent of Code 2017
 *
 * No refactoring or improvements done
 * @author Julian Kotrba
 */

class Day21 {

    private val startPattern = listOf(
            ".#.".map { it.toString() },
            "..#".map { it.toString() },
            "###".map { it.toString() }
    )

    fun calcPart1(input: List<String>): Int {
        var pattern = startPattern

        for (i in 0 until 5) {
            val divider = if (pattern.size.rem(2) == 0) 2 else 3
            pattern = this.enhancePattern(input, pattern, divider)
        }

        return pattern.map {
            it.filter { s -> s == "#" }.size
        }.sum()
    }

    fun calcPart2(input: List<String>): Int {
        var pattern = startPattern

        for (i in 0 until 18) {
            val divider = if (pattern.size.rem(2) == 0) 2 else 3
            pattern = this.enhancePattern(input, pattern, divider)
        }

        return pattern.map {
            it.filter { s -> s == "#" }.size
        }.sum()
    }

    private fun enhancePattern(input: List<String>, pattern: List<List<String>>, divider: Int): MutableList<MutableList<String>> {
        val enhancedPattern = mutableListOf<MutableList<String>>()
        for (y in 0 until pattern[0].size step divider) {

            for (x in 0 until pattern.size step divider) {

                val p = mutableListOf<MutableList<String>>()
                for (i in 0 until divider) {
                    val row = mutableListOf<String>()
                    for (j in 0 until divider) {
                        row.add(pattern[y + i][x + j])
                    }
                    p.add(row)
                }

                val tmp = matchingToPattern(getMatching(input, p))
                tmp.forEachIndexed { i, e ->

                    if (y > 0) {

                        if (y + i + (y / divider) >= enhancedPattern.size) {
                            enhancedPattern.add(e.toMutableList())
                        } else enhancedPattern[y + i + (y / divider)].addAll(e)

                    } else {

                        if (y + i >= enhancedPattern.size) {
                            enhancedPattern.add(e.toMutableList())
                        } else enhancedPattern[y + i].addAll(e)
                    }

                }
            }

        }

        return enhancedPattern
    }

    private fun matchingToPattern(matching: String): List<List<String>> {
        val p = mutableListOf<MutableList<String>>()
        matching.split("/").forEach {
            p.add(it.map { c -> c.toString() }.toMutableList())
        }

        return p
    }

    private fun getMatching(input: List<String>, pattern: List<List<String>>): String {
        val combinations = getAllCombinations(pattern)

        lateinit var matching: String
        input.forEach {
            val parts = it.split(" => ")

            if (combinations.contains(parts[0])) {
                matching = parts[1]
            }

        }

        return matching
    }

    private fun flipPatter(pattern: List<List<String>>): List<List<String>> {
        return pattern.map { it.asReversed() }
    }

    private fun rotatePattern(pattern: List<List<String>>): List<List<String>> {
        val newList = mutableListOf<List<String>>()

        for (i in 0 until pattern.size) {
            val row = mutableListOf<String>()
            for (j in pattern.size.minus(1) downTo 0) {
                row.add(pattern[j][i])
            }
            newList.add(row)
        }

        return newList

    }

    private fun patternAsInputString(pattern: List<List<String>>): String {
        val sb = StringBuilder()

        pattern.forEach {
            sb.append(it.joinToString(""))
            sb.append("/")
        }

        return sb.toString().removeSuffix("/")
    }

    private fun getAllCombinations(pattern: List<List<String>>): Set<String> {

        val combinations = mutableSetOf<String>()
        var rot = pattern

        for (i in 0 until 4) {
            val rotated = rotatePattern(rot)
            combinations.add(patternAsInputString(rotated))
            combinations.add(patternAsInputString(flipPatter(rotated)))

            rot = rotated
        }

        return combinations
    }

}


