/**
 * Day twenty-five of Advent of Code 2017
 *
 * NO REFACTORING DONE! :(
 * @author Julian Kotrba
 */

class Day25 {

    fun calcPart1(statesMap: Map<Char, State>, steps: Int): Int {
        val band = mutableListOf(0)
        var currPos = 0
        var currState = 'A'

        (0 until steps).forEach {

            val state: State = statesMap.getOrDefault(currState, State(0, 0, 0, 'A', 0, 0, 'A'))

            if (band[currPos] == state.case1CompValue) {
                band[currPos] = state.case1WriteValue
                currState = state.case1NextState

                currPos = move(band, currPos, state.case1MoveValue)
            } else {
                band[currPos] = state.case2WriteValue
                currState = state.case2NextState

                currPos = move(band, currPos, state.case2MoveValue)
            }

        }

        return band.count { it == 1 }
    }

    private fun move(band: MutableList<Int>, currPos: Int, dir: Int): Int {
        var newPos = currPos

        // WTF?!
        if (dir < 0) {
            if (currPos == 0) {
                band.add(0, 0)
            } else {
                newPos = currPos - 1
            }
        } else {

            if (currPos == band.size.minus(1)) {
                band.add(0)
            }

            newPos = currPos + 1
        }

        return newPos
    }

}

data class State(val case1CompValue: Int, val case1WriteValue: Int, val case1MoveValue: Int, val case1NextState: Char, val case2WriteValue: Int, val case2MoveValue: Int, val case2NextState: Char)


