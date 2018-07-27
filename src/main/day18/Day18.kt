import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit
import kotlin.NumberFormatException

/**
 * Day eighteen of Advent of Code 2017
 *
 * @author Julian Kotrba
 */

class Day18 {

    fun calcPart1(input: List<String>): Long {
        val registers = mutableMapOf<String, Long>()

        var lastPlayed = 0L
        var isRecovered = false
        var i = 0
        var jmpValue = 0L
        var isJump = false
        while(!isRecovered) {

            val cmd = input[i]

            when {

                cmd.startsWith("snd") -> {
                    val params = this.parseCommandParams(cmd, registers)
                    lastPlayed = registers.getOrDefault(params.first, 0)

                    println("CMD: $cmd, Playing $lastPlayed")
                }

                cmd.startsWith("set") -> {
                    val params = this.parseCommandParams(cmd, registers)
                    registers.put(params.first, params.second)

                    println("Setting register ${params.first}, to ${params.second}")
                }

                cmd.startsWith("add") -> {
                    val params = this.parseCommandParams(cmd, registers)
                    val currentValueOfX = registers.getOrDefault(params.first, 0)
                    registers.put(params.first, currentValueOfX.plus(params.second))

                    println("Setting register ${params.first}, to ${currentValueOfX.plus(params.second)}")
                }

                cmd.startsWith("mul") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    val currentValueOfX = registers.getOrDefault(params.first, 0)
                    registers.put(params.first, currentValueOfX.times(params.second))

                    println("Setting register ${params.first}, to ${currentValueOfX.times(params.second)}")
                }

                cmd.startsWith("mod") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    val currentValueOfX = registers.getOrDefault(params.first, 0)
                    registers.put(params.first, currentValueOfX.rem(params.second))

                    println("Setting register ${params.first}, to ${currentValueOfX.rem(params.second)}")
                }

                cmd.startsWith("rcv") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    if (registers.getOrDefault(params.first, 0) != 0L) {
                        isRecovered = true
                        println("RECOVERING: $lastPlayed")
                    } else println("Ignoring CMD: $cmd")
                }

                cmd.startsWith("jgz") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    if (registers.getOrDefault(params.first, 0) > 0) {
                        isJump = true
                        jmpValue = params.second

                        println("Jumping ${params.second}")
                    }
                }
            }


            i = if (isJump) {
                isJump = false
                i.plus(jmpValue.toInt())
            } else i.plus(1)
        }

        return lastPlayed
    }

    fun calcPart2(input: List<String>): Int {

        val q1 = ArrayBlockingQueue<Long>(1024)
        val q2 = ArrayBlockingQueue<Long>(1024)

        val reg1 = mutableMapOf<String, Long>()
        val reg2 = mutableMapOf<String, Long>()

        var sendCounter = 0
        val thread1 = Thread({
            this.runner(0, input, reg1, q1, q2)
        })

        val thread2 = Thread({
            sendCounter = this.runner(1, input, reg2, q2, q1)
        })

        thread1.start()
        thread2.start()

        thread1.join()
        thread2.join()


        return sendCounter
    }

    private fun parseCommandParams(cmd: String, registers: Map<String, Long>): Pair<String, Long> {
        val parts = cmd.split(" ")

        val register = parts[1]
        val value: Long = if (parts.size == 3) {
            try {
                parts[2].toLong()
            } catch (e: NumberFormatException) {
                registers.getOrDefault(parts[2] ,0)
            }
        } else {
            Long.MIN_VALUE
        }


        return Pair(register, value)
    }

    private fun runner(id: Int, input: List<String>, registers: MutableMap<String, Long>, qToPut: BlockingQueue<Long>, qToRead: BlockingQueue<Long>): Int {

        var lastPlayed = 0L
        var isRecovered = false
        var i = 0
        var jmpValue = 0L
        var isJump = false

        var sendCounter = 0

        registers.put("p", id.toLong())

        while(!isRecovered) {

            val cmd = input[i]

            when {

                cmd.startsWith("snd") -> {
                    val params = this.parseCommandParams(cmd, registers)
                    //lastPlayed = registers.getOrDefault(params.first, 0)
                    sendCounter++
                    val send = try {
                        cmd.split(" ")[1].toLong()
                    } catch (e: NumberFormatException) {
                        registers.getOrDefault(cmd.split(" ")[1], 0)
                    }

                    qToPut.put(send)

                    println("Program$id sending $send. Sent $sendCounter messages")
                }

                cmd.startsWith("set") -> {
                    val params = this.parseCommandParams(cmd, registers)
                    registers.put(params.first, params.second)

                    println("Setting register ${params.first} to ${params.second}")
                }

                cmd.startsWith("add") -> {
                    val params = this.parseCommandParams(cmd, registers)
                    val currentValueOfX = registers.getOrDefault(params.first, 0)
                    registers.put(params.first, currentValueOfX.plus(params.second))

                    println("Setting register ${params.first}, to ${currentValueOfX.plus(params.second)}")
                }

                cmd.startsWith("mul") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    val currentValueOfX = registers.getOrDefault(params.first, 0)
                    registers.put(params.first, currentValueOfX.times(params.second))

                    println("Setting register ${params.first}, to ${currentValueOfX.times(params.second)}")
                }

                cmd.startsWith("mod") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    val currentValueOfX = registers.getOrDefault(params.first, 0)
                    registers.put(params.first, currentValueOfX.rem(params.second))

                    println("Setting register ${params.first}, to ${currentValueOfX.rem(params.second)}")
                }

                cmd.startsWith("rcv") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    println("Program$id waiting ..")

                    val readVal: Long? = qToRead.poll(10, TimeUnit.SECONDS)
                    println("Program$id received $readVal and putting into ${params.first}")

                    if (readVal != null)  {
                        registers.put(params.first, readVal)
                    } else {
                        return sendCounter
                    }
                }

                cmd.startsWith("jgz") -> {
                    val params = this.parseCommandParams(cmd, registers)

                    val jumpValue = try {
                        cmd.split(" ")[1].toLong()
                    } catch (e: NumberFormatException) {
                        registers.getOrDefault(cmd.split(" ")[1], 0)
                    }

                    if (jumpValue > 0) {
                        isJump = true
                        jmpValue = params.second

                        println("Jumping ${params.second}")
                    }
                }
            }

            i = if (isJump) {
                isJump = false
                i.plus(jmpValue.toInt())
            } else i.plus(1)
        }

        return sendCounter
    }

}


