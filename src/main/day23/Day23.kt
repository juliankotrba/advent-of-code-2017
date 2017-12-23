/**
 * Day twenty-three of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day23 {

    fun calcPart1(input: List<String>): Int {
        val registers = mutableMapOf<String, Long>()

        var counter = 0
        var i = 0
        var jmpValue = 0L
        var isJump = false

        while(i < input.size) {

            val cmd = input[i]

            when {

                cmd.startsWith("set") -> {
                    val parts = cmd.split(" ")

                    val value = try {
                        parts[2].toLong()
                    } catch (e: NumberFormatException) {
                        registers.getOrDefault(parts[2], 0)
                    }

                    registers.put(parts[1], value)
                }

                cmd.startsWith("sub") -> {
                    val parts = cmd.split(" ")

                    val value = try {
                        parts[2].toLong()
                    } catch (e: NumberFormatException) {
                        registers.getOrDefault(parts[2], 0)
                    }

                    val currentValueOfX = registers.getOrDefault(parts[1], 0)
                    registers.put(parts[1], currentValueOfX.minus(value))
                }

                cmd.startsWith("mul") -> {
                    val parts = cmd.split(" ")

                    val value = try {
                        parts[2].toLong()
                    } catch (e: NumberFormatException) {
                        registers.getOrDefault(parts[2], 0)
                    }

                    val currentValueOfX = registers.getOrDefault(parts[1], 0)
                    registers.put(parts[1], currentValueOfX.times(value))
                    counter++
                }

                cmd.startsWith("jnz") -> {

                    val parts = cmd.split(" ")

                    val num = try {
                        parts[1].toLong()
                    } catch (e: NumberFormatException) {
                        registers.getOrDefault(parts[1], 0)
                    }

                    if (num != 0L) {
                        isJump = true
                        jmpValue = parts[2].toLong()
                    }
                }
            }

            i = if (isJump) {
                isJump = false
                i.plus(jmpValue.toInt())
            } else i.plus(1)

        }

        return counter
    }

    fun calcPart2(): Int {
        return (108100 .. 125100 step 17).count { !isPrim(it) }
    }

    private fun isPrim(value: Int): Boolean {
        return (2 until value).none { value % it == 0 }
    }

}


