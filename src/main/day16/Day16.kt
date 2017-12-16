/**
 * Day sixteen of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day16 {

    fun calcPart1(programs: MutableList<String>, commands: List<String>): MutableList<String> {
        var ps = programs
        commands.forEach {

            when {
                it.startsWith("s") -> {

                    val spinSize = Integer.valueOf(it.substring(1, it.length))

                    val newlist = mutableListOf<String>()
                    newlist.addAll(ps.subList(programs.size.minus(spinSize), ps.size))
                    newlist.addAll(ps.subList(0, ps.size.minus(spinSize)))
                    ps = newlist

                }
                it.startsWith("x") -> {
                    val swapPositions = it.subSequence(1, it.length).split("/")

                    val pos1 = Integer.valueOf(swapPositions[0])
                    val pos2 = Integer.valueOf(swapPositions[1])

                    ps.swapByIndex(pos1, pos2)
                }
                it.startsWith("p") -> {
                    val swapValues = it.subSequence(1, it.length).split("/")

                    val val1 = swapValues[0]
                    val val2 = swapValues[1]

                    ps.swapByUniqueValue(val1, val2)
                }
            }

        }


       return ps
    }

    fun calcPart2(programs: MutableList<String>, commands: List<String>): String {
        var ps = programs

        val danceCycle = mutableListOf<String>()
        (0 until 1_000_000_000).forEach {

            if (danceCycle.contains(ps.joinToString(""))) {
                return danceCycle[1_000_000_000.rem(it)]
            }

            danceCycle.add(ps.joinToString(""))
            ps = this.calcPart1(ps, commands)
        }

        println(ps.joinToString(""))
        return ps.joinToString("")
    }

    private fun MutableList<String>.swapByIndex(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    private fun MutableList<String>.swapByUniqueValue(v1: String, v2: String) {
        this.swapByIndex(this.indexOf(v1), this.indexOf(v2))
    }

}


