package day7

/**
 * Created by Julian Kotrba on 07.12.17.
 */
data class Node (var name: String, var weight: Int, val predecessors: MutableList<Node>, val successor: MutableList<Node>) {

    var overallWeight = -1
        get() = if (field==-1) weight else field
}