/**
 * Day ten of Advent of Code 2017
 *
 * hangover coding..
 * @author Julian Kotrba
 */

class Day10 {

    fun calcPart1(listOfNumbers: MutableList<Int>, sequenceOfLengths: List<Int>): Int {
        var skipSize = 0
        var index = 0

        sequenceOfLengths.forEach {

            if (index.plus(it) >= listOfNumbers.size) {

                val tmpList = mutableListOf<Int>()

                (index until index.plus(it)).forEach {
                    tmpList.add(listOfNumbers[it.rem(listOfNumbers.size)])
                }

                (index until index.plus(it)).forEach {
                    listOfNumbers[it.rem(listOfNumbers.size)] = tmpList.asReversed().removeAt(0)
                }

            } else {

                val from = index
                val to = index.plus(it).minus(1)

                val rev = ArrayList(listOfNumbers.subList(from, to.plus(1))).asReversed()
                (from ..  to).forEach {
                    listOfNumbers[it] = rev.removeAt(0)
                }
            }

            index = (index.plus(skipSize).plus(it)).rem(listOfNumbers.size)
            skipSize++
        }

        return listOfNumbers[0].times(listOfNumbers[1])
    }


    fun calcPart2(listOfNumbers: MutableList<Int>, sequence: String): String {
        val sequenceOfLengths = convertLengths(sequence)
        sequenceOfLengths.addAll(listOf(17, 31, 73, 47, 23))

        var index = 0
        var skipSize = 0
        for (i in 0 until 64) {
            sequenceOfLengths.forEach {

                if (index.plus(it) >= listOfNumbers.size) {

                    val tmpList = mutableListOf<Int>()

                    (index until index.plus(it)).forEach {
                        tmpList.add(listOfNumbers[it.rem(listOfNumbers.size)])
                    }

                    (index until index.plus(it)).forEach {
                        listOfNumbers[it.rem(listOfNumbers.size)] = tmpList.asReversed().removeAt(0)
                    }

                } else {

                    val from = index
                    val to = index.plus(it).minus(1)

                    val rev = ArrayList(listOfNumbers.subList(from, to.plus(1))).asReversed()
                    (from ..  to).forEach {
                        listOfNumbers[it] = rev.removeAt(0)
                    }
                }

                index = (index.plus(skipSize).plus(it)).rem(listOfNumbers.size)
                skipSize++
            }
        }

        val sb = StringBuilder()
        (0 until 16)
                .map { doXor(listOfNumbers.subList(it *16, (it *16).plus(16))) }
                .map { if(it.toString(16).length == 1) "0"+ it.toString(16) else it.toString(16) }
                .forEach { sb.append(it) }

        return sb.toString()
    }

    private fun doXor(l : List<Int>): Int {
        var v = 0
        l.forEach {
           v = v xor it
        }
        return v
    }
    private fun convertLengths(lengths: String): MutableList<Int> {
        return lengths.map {
            Integer.valueOf(it.toByte().toString())
        }.toMutableList()
    }

}


