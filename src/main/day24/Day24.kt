/**
 * Day twenty-four of Advent of Code 2017
 *
 * @author Julian Kotrba
 */

class Day24 {

    fun calcPart1(input: MutableList<Pair<Int, Int>>): Int {
        val bridgeValues = mutableListOf<Int>()
        val pairs: List<Pair<Int, Int>> = mutableListOf()
        val allPairs = mutableListOf<List<Pair<Int, Int>>>()

        branch(input, 0, input.filter { it.first == 0 }.toMutableList(), bridgeValues, pairs, allPairs)

        return bridgeValues.max()!!
    }

    private fun branch(input: MutableList<Pair<Int, Int>>, currStrength: Int, branches: MutableList<Pair<Int, Int>>, bridgeValues: MutableList<Int>, pairs: List<Pair<Int, Int>>, allPairs: MutableList<List<Pair<Int, Int>>>) {

        if (branches.isEmpty()) {
            bridgeValues.add(currStrength)
            allPairs.add(pairs)
        }

        branches.forEach {
            val inputCopy = input.toMutableList()

            if (inputCopy === input) throw RuntimeException("Not a copy")

            inputCopy.remove(it)

            val newBranches = inputCopy.filter { fit -> it.second == fit.first || it.second == fit.second }.map { fit ->

                if (it.second == fit.first) {
                    fit
                } else {
                    inputCopy.remove(fit)
                    inputCopy.add(Pair(fit.second, fit.first))
                    Pair(fit.second, fit.first)
                }
            }.toMutableList()

            val newPairs = pairs.toMutableList()
            newPairs.add(it)

            branch(inputCopy, currStrength.plus(it.first).plus(it.second), newBranches, bridgeValues, newPairs, allPairs)
        }
    }

    fun calcPart2(input: MutableList<Pair<Int, Int>>): Int {
        val bridgeValues = mutableListOf<Int>()
        val pairs: List<Pair<Int, Int>> = mutableListOf()
        val allPairs = mutableListOf<List<Pair<Int, Int>>>()

        branch(input, 0, input.filter { it.first == 0 }.toMutableList(), bridgeValues, pairs, allPairs)

        val size = allPairs.maxBy { l -> l.size }!!.size
        return allPairs.filter { it.size == size }.map {
            var strength = 0
            it.forEach { pair ->
                strength = strength.plus(pair.first).plus(pair.second)
            }
            strength
        }.max()!!

    }

}


