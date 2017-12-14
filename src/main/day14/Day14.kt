/**
 * Day fourteen of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day14 {

    fun calcPart1(input: String): Int {
        val day10 = Day10()

        return (0 .. 127).map {
            val hash = day10.calcPart2((0 .. 255).toMutableList(), input+"-$it")
            this.convertHash(hash)
        }.map {
            it.replace("0", "").length
        }.sum()

    }

    fun calcPart2(input: String): Int {
        val day10 = Day10()
        val rows = (0 .. 127).map {
            val hash = day10.calcPart2((0 .. 255).toMutableList(), input+"-$it")
            this.convertHash(hash).map { Integer.valueOf(it.toString()) }.toMutableList()
        }.toMutableList()

        val visited = mutableSetOf<Pair<Int, Int>>()
        var groupCount = 0

        rows.forEachIndexed { y, row ->
            row.forEachIndexed { x, elem ->
                if (!visited.contains(Pair(x,y)) && elem != 0) {
                    visited.add(Pair(x,y))
                    groupCount++
                    dfs(rows, visited, Pair(x,y))
                }
            }
        }

        return groupCount
    }


    private fun convertHash(hash: String): String {
        return hash.map {
            fillWithZeros(Integer.toBinaryString(Integer.parseInt(it.toString(), 16)))
        }.joinToString("")
    }

    private fun fillWithZeros(bits: String): String {
        var filledBits = bits
        while (filledBits.length < 4) {
            filledBits = "0"+filledBits
        }

        return filledBits
    }

    private fun dfs(rows: MutableList<MutableList<Int>>, visitied: MutableSet<Pair<Int, Int>>, pos: Pair<Int, Int>) {

        // left
        if (pos.first != 0 && rows[pos.second][pos.first.minus(1)] == 1 && !visitied.contains(Pair(pos.first.minus(1), pos.second))) {

            visitied.add(Pair(pos.first.minus(1), pos.second))
            dfs(rows, visitied, Pair(pos.first.minus(1), pos.second))
        }

        // right
        if (pos.first != rows[pos.second].size.minus(1) && rows[pos.second][pos.first.plus(1)] == 1 && !visitied.contains(Pair(pos.first.plus(1), pos.second))) {

            visitied.add((Pair(pos.first.plus(1), pos.second)))
            dfs(rows, visitied, Pair(pos.first.plus(1), pos.second))
        }

        // top
        if (pos.second != 0 && rows[pos.second.minus(1)][pos.first] == 1 && !visitied.contains(Pair(pos.first, pos.second.minus(1)))) {

            visitied.add(Pair(pos.first, pos.second.minus(1)))
            dfs(rows, visitied, Pair(pos.first, pos.second.minus(1)))
        }

        // Bottom
        if (pos.second != rows.size.minus(1)  && rows[pos.second.plus(1)][pos.first] == 1 && !visitied.contains(Pair(pos.first, pos.second.plus(1)))) {

            visitied.add(Pair(pos.first, pos.second.plus(1)))
            dfs(rows, visitied, Pair(pos.first, pos.second.plus(1)))
        }

    }

}


