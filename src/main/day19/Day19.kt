/**
 * Day nineteen of Advent of Code 2017
 *
 * Part 2 is just printing the step counter
 *
 * @author Julian Kotrba
 */

class Day19 {

    enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }

    fun calcPart1(input: List<List<String>>): String {
        val letters = mutableListOf<String>()

        val start = Pair(0, input[0].indexOf("|"))
        val direction = Direction.SOUTH

        new(input, start, direction, letters,0)

        return letters.joinToString("")
    }

    fun calcPart2(input: List<List<String>>) {
        val letters = mutableListOf<String>()

        val start = Pair(0, input[0].indexOf("|"))
        val direction = Direction.SOUTH

        new(input, start, direction, letters, 1)
    }

    private tailrec fun new(input: List<List<String>>, position: Pair<Int, Int>, direction: Direction, letters: MutableList<String>, count: Int) {
        var isExtraStep = false
        var pos = position
        var dir = direction
        when (input[position.first][position.second]) {
            "-" -> {

                when(direction) {

                    Direction.EAST -> {
                        pos = Pair(position.first, position.second.plus(1))

                        if (input[position.first][position.second.plus(1)] == "|") {
                            pos = Pair(position.first, position.second.plus(2))
                            isExtraStep = true
                        }
                    }

                    Direction.WEST -> {
                        pos = Pair(position.first, position.second.minus(1))

                        if (input[position.first][position.second.minus(1)] == "|") {
                            pos = Pair(position.first, position.second.minus(2))
                            isExtraStep = true
                        }
                    }

                    else -> throw RuntimeException("Shouldnt happen. Pos: $position, direction: $direction")
                }
            }

            "|" -> {

                when(direction) {

                    Direction.SOUTH -> {
                        pos = Pair(position.first.plus(1), position.second)

                        if (input[position.first.plus(1)][position.second] == "-") {
                            pos = Pair(position.first.plus(2), position.second)
                            isExtraStep = true
                        }
                    }

                    Direction.NORTH -> {
                        pos = Pair(position.first.minus(1), position.second)

                        if (input[position.first.minus(1)][position.second] == "-") {
                            pos = Pair(position.first.minus(2), position.second)
                            isExtraStep = true
                        }
                    }

                    else -> throw RuntimeException("Shouldnt happen. Pos: $position, direction: $direction")
                }

            }

            "+" -> {

                if (direction != Direction.SOUTH && isInBounds(input, position.first.minus(1), position.second) && (input[position.first.minus(1)][position.second] == "|" || Character.isLetter(input[position.first.minus(1)][position.second].toCharArray()[0]))) {
                    //println("Going up")
                    dir = Direction.NORTH
                    pos = Pair(position.first.minus(1), position.second)
                } else if (direction != Direction.NORTH && isInBounds(input, position.first.plus(1), position.second) && (input[position.first.plus(1)][position.second] == "|" || Character.isLetter(input[position.first.plus(1)][position.second].toCharArray()[0]))) {
                    //println("Going down")
                    dir = Direction.SOUTH
                    pos = Pair(position.first.plus(1), position.second)
                } else if (direction != Direction.EAST && isInBounds(input, position.first, position.second.minus(1)) && (input[position.first][position.second.minus(1)] == "-" || Character.isLetter(input[position.first][position.second.minus(1)].toCharArray()[0]))) {
                    //println("Going left")
                    dir = Direction.WEST
                    pos = Pair(position.first, position.second.minus(1))
                } else if (direction != Direction.WEST && isInBounds(input, position.first, position.second.plus(1)) && (input[position.first][position.second.plus(1)] == "-" || Character.isLetter(input[position.first][position.second.plus(1)].toCharArray()[0]))) {
                    //println("Going right")
                    dir = Direction.EAST
                    pos = Pair(position.first, position.second.plus(1))
                }

            }

            else -> {
                // LETTER
                letters.add(input[position.first][position.second])

                when (direction) {

                    Direction.SOUTH -> {

                        if(input[position.first.plus(1)][position.second] == " ") {
                            println("Steps $count")
                            return
                        }

                        pos = Pair(position.first.plus(1), position.second)

                        if (input[position.first.plus(1)][position.second] == "|") {
                            pos = Pair(position.first.plus(2), position.second)
                            isExtraStep = true

                        }

                    }
                    Direction.NORTH -> {

                        if(input[position.first.minus(1)][position.second] == " ") {
                            println("Steps $count")
                            return
                        }

                        pos = Pair(position.first.minus(1), position.second)

                        if (input[position.first.minus(1)][position.second] == "-") {
                            pos = Pair(position.first.minus(2), position.second)
                            isExtraStep = true
                        }

                    }
                    Direction.WEST -> {

                        if(input[position.first][position.second.minus(1)] == " ") {
                            println("Steps $count")
                            return
                        }

                        pos = Pair(position.first, position.second.minus(1))

                        if (input[position.first][position.second.minus(1)] == "|") {
                            pos = Pair(position.first, position.second.minus(2))
                            isExtraStep = true
                        }

                    }
                    Direction.EAST -> {

                        if(input[position.first][position.second.plus(1)] == " ") {
                            println("Steps $count")
                            return

                        }

                        pos = Pair(position.first, position.second.plus(1))

                        if (input[position.first][position.second.plus(1)] == "|") {
                            pos = Pair(position.first, position.second.plus(2))
                            isExtraStep = true
                        }
                    }
                }

            }
        }


        val c = count.plus(1).plus(if (isExtraStep) 1 else 0)
        new(input, pos, dir, letters, c)
    }

    private fun isInBounds(input: List<List<String>>, y: Int, x: Int): Boolean {
        return (y < input.size) && (x < input[y].size)

    }

}


