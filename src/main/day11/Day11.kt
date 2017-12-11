import kotlin.math.abs

/**
 * Day eleven of Advent of Code 2017
 *
 * Solved with help from this site:
 * https://www.redblobgames.com/grids/hexagons/
 *
 * @author Julian Kotrba
 */

class Day11 {

    fun calcPart1(input: List<String>): Int {
        var x = 0
        var y = 0
        var z = 0


        input.forEach {

            when (it) {
                "n" -> {
                    y++; x--
                }
                "ne" -> {
                    y++; z--
                }
                "se" -> {
                    z--; x++
                }
                "s" -> {
                    y--; x++
                }
                "sw" -> {
                    y--; z++
                }
                "nw" -> {
                    x--; z++
                }
            }
        }

        return calcDist(x, y, z)
    }

    fun calcPart2(input: List<String>): Int {
        var x = 0
        var y = 0
        var z = 0

        var furthestSteps = 0

        input.forEach {

            when (it) {
                "n" -> {
                    y++; x--
                    furthestSteps = if(calcDist(x,y,z) > furthestSteps) calcDist(x,y,z) else furthestSteps
                }
                "ne" -> {
                    y++; z--
                    furthestSteps = if(calcDist(x,y,z) > furthestSteps) calcDist(x,y,z) else furthestSteps
                }
                "se" -> {
                    z--; x++
                    furthestSteps = if(calcDist(x,y,z) > furthestSteps) calcDist(x,y,z) else furthestSteps
                }
                "s" -> {
                    y--; x++
                    furthestSteps = if(calcDist(x,y,z) > furthestSteps) calcDist(x,y,z) else furthestSteps
                }
                "sw" -> {
                    y--; z++
                    furthestSteps = if(calcDist(x,y,z) > furthestSteps) calcDist(x,y,z) else furthestSteps
                }
                "nw" -> {
                    x--; z++
                    furthestSteps = if(calcDist(x,y,z) > furthestSteps) calcDist(x,y,z) else furthestSteps
                }
            }
        }

        return furthestSteps
    }

    private fun calcDist(x: Int, y: Int, z: Int): Int {
        return (abs(x) + abs(y) + abs(z)).div(2)
    }

}


