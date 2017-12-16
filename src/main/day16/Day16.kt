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

                    ps = ps.spin(spinSize)

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

    private fun MutableList<String>.spin(spinSize: Int): MutableList<String> {
        val new = mutableListOf<String>()
        new.addAll(this.subList(this.size.minus(spinSize), this.size))
        new.addAll(this.subList(0, this.size.minus(spinSize)))

        return new
    }

}


