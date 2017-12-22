/**
 * Day twenty-two of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day22 {

    enum class Direction {
        UP, DOWN, LEFT, RIGHT
    }

    companion object {
        const val ITERATIONS_P1 = 1_000
        const val ITERATIONS_P2 = 10_000_000
    }

    fun calcPart1(input: MutableList<MutableList<Char>>): Int {
        var infectionCount = 0
        var direction = Direction.UP
        var currentPos = Pair(input.size.div(2), input[1].size.div(2))

        for (i in 0 until ITERATIONS_P1) {

            when(input[currentPos.first][currentPos.second]) {

                 '.' -> {
                     direction = direction.turnLeft()
                     input[currentPos.first][currentPos.second] = '#'
                     infectionCount++
                 }

                '#' -> {
                    direction = direction.turnRight()
                    input[currentPos.first][currentPos.second] = '.'
                }
            }

            currentPos  = this.move(currentPos, direction, input)
        }

        return infectionCount
    }

    fun calcPart2(input: MutableList<MutableList<Char>>): Int {
        var infectionCount = 0
        var direction = Direction.UP
        var currentPos = Pair(input.size.div(2), input[1].size.div(2))

        for (i in 0 until ITERATIONS_P2) {

            when(input[currentPos.first][currentPos.second]) {

                '.' -> {
                    direction = direction.turnLeft()
                    input[currentPos.first][currentPos.second] = 'W'
                }

                '#' -> {
                    direction = direction.turnRight()
                    input[currentPos.first][currentPos.second] = 'F'
                }

                'F' -> {
                    direction = direction.reverseDirection()
                    input[currentPos.first][currentPos.second] = '.'
                }

                'W' -> {
                    input[currentPos.first][currentPos.second] = '#'
                    infectionCount++
                }
            }

            currentPos  = this.move(currentPos, direction, input)
        }

        return infectionCount
    }

    private fun Direction.turnLeft(): Direction {
        return when(this) {
            Direction.UP -> Direction.LEFT
            Direction.DOWN -> Direction.RIGHT
            Direction.LEFT -> Direction.DOWN
            Direction.RIGHT -> Direction.UP
        }
    }

    private fun Direction.turnRight(): Direction {
        return when(this) {
            Direction.UP -> Direction.RIGHT
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
            Direction.RIGHT -> Direction.DOWN
        }
    }

    private fun Direction.reverseDirection(): Direction {
        return when(this) {
            Direction.UP -> Direction.DOWN
            Direction.DOWN -> Direction.UP
            Direction.LEFT -> Direction.RIGHT
            Direction.RIGHT -> Direction.LEFT
        }
    }



    private fun move(pos: Pair<Int, Int>, direction: Direction, input: MutableList<MutableList<Char>>): Pair<Int, Int> {
        val newPosition: Pair<Int, Int>
        when(direction) {
            Direction.UP -> {
                newPosition = if (pos.first == 0) {
                    input.add(0, MutableList(input[0].size , { '.'} ))
                    pos
                } else {
                    Pair(pos.first.minus(1), pos.second)
                }

            }
            Direction.DOWN -> {
                if (pos.first == input.size.minus(1)) {
                    input.add(MutableList(input[0].size , { '.'} ))
                }

                newPosition = Pair(pos.first.plus(1), pos.second)
            }
            Direction.LEFT -> {

                newPosition = if (pos.second == 0) {
                    input.forEach { it.add(0, '.') }
                    pos
                } else {
                    Pair(pos.first, pos.second.minus(1))
                }
            }
            Direction.RIGHT -> {

                if (pos.second == input[0].size.minus(1)) {
                    input.forEach { it.add('.') }
                }

                newPosition = Pair(pos.first, pos.second.plus(1))
            }
        }

        return newPosition
    }

    private fun printField(input: MutableList<MutableList<Char>>) {
        input.forEach { println(it.joinToString("")) }
    }

}


