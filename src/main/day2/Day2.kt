/**
 * Day two, part 2 of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day2 {

    // we really should not store the whole spreadsheet in one data structure
    // but for the sake of this AoC challenge it should be fine ..
    // better approach would be to read row by row
    fun calcPart1(input: List<List<Int>>): Int {
        return input.map {
            it.max()?.minus(it.min() ?: 0) ?: 0
        }.sum()
    }

    fun calcPart2(input: List<List<Int>>): Int {
        return input.map {
            val sortedDesc = it.sorted().asReversed()
            var rowResult = 0

            sortedDesc.forEachIndexed({ i, fixedValue ->
                (i.plus(1) until sortedDesc.size)
                        .filter { fixedValue % sortedDesc[it] == 0 }
                        .forEach { rowResult = fixedValue.div(sortedDesc[it]) }
            })
            rowResult
        }.sum()
    }

}