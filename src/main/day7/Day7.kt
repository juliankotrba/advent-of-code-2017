import day7.Node

/**
 * Day seven of Advent of Code 2017
 * @author Julian Kotrba
 *
 * ad. part 2:
 *
 * Really solved it with print() debug lines.
 * After that tried to find a quick solution to print the result to stdout which
 * seems to work only if one of the successors weight is wrong.
 * so this solution works with the puzzle input but not with the example from the instruction
 * Unfortunately there is really no time for refactoring this ugly code or finding a proper solution..
 */

class Day7 {

    fun calcPart1(input: List<String>): Node {

        var currentNode = this.findAnyLeaf(input)
        var foundBottom = false

        while (!foundBottom) {
            foundBottom = true
            input.forEach {
                if (it.contains("->")) {
                    val nodes = it.split("->")[1]

                    if (nodes.contains(currentNode.name)) {
                        foundBottom = false

                        currentNode = this.createNodeFromInputString(it)
                    }
                }
            }
        }
        return currentNode
    }

    fun calcPart2(input: List<String>) {

        val rootNode = this.calcPart1(input)

        buildTree(rootNode, input)

        rootNode.successor.forEach {
            rec(it)
            println("Sum ${it.overallWeight} with weight ${it.weight} name: ${it.name}")
        }

    }

    private fun buildTree(root: Node, input: List<String>) {
        this.setChildNodes(root, input)
    }

    private fun rec(node: Node) {

        if (!node.successor.isEmpty()) {
            node.successor.forEach {
                rec(it)
            }
        }

        if (!node.successor.isEmpty()) {

            val tmp = node.successor[0].overallWeight
            val sum = node.successor.map {
                if (it.overallWeight != tmp) {
                    findWrongWeight(node.successor)
                }

                it.overallWeight
            }.sum()

            node.overallWeight = sum + node.overallWeight

        }
    }

    private fun findWrongWeight(nodes: List<Node>) {
        val v1 = nodes.groupingBy { it.overallWeight }.eachCount().toList()[0].second
        val v2 = nodes.groupingBy { it.overallWeight }.eachCount().toList()[1].second

        val x1 = nodes.groupingBy { it.overallWeight }.eachCount().toList()[0].first
        val x2 = nodes.groupingBy { it.overallWeight }.eachCount().toList()[1].first

        val diff = if (v1 > v2) {
            x1-x2
        } else {
            x2-x1
        }

        nodes.filter { nodes.groupingBy { it.overallWeight }.eachCount()[it.overallWeight] == 1 }
                .forEach {

                    println("================================")
                    println("Need to adjust node ${it.name} with weight ${it.weight}")
                    println("New weight: ${it.weight.plus(diff)}")
                    println("================================")

                    it.overallWeight = it.overallWeight.plus(diff)
                    it.weight = it.weight.plus(diff)
                    return
                }
    }

    private fun setChildNodes(node: Node, input: List<String>) {

        input.forEach {

            if (it.contains("->") && it.split("->")[0].contains(node.name)) {
                node.name = this.getNodeNameFromParsedString(it)
                node.weight = this.getNodeWeightFromParsedString(it)

                it.split("->")[1].split(",").forEach { it2 ->
                    val child = Node(it2.trim(), -1, mutableListOf(), mutableListOf())
                    node.successor.add(child)
                }

                node.successor.forEach { n->
                    this.setChildNodes(n, input)
                }


            } else if (!it.contains("->") && it.contains(node.name)){ // LEAF
                node.name = this.createNodeFromInputString(it).name
                node.weight = this.createNodeFromInputString(it).weight
            }

        }

    }

    private fun findAnyLeaf(input: List<String>): Node {

        input.forEach {
            if (!it.contains("->")) {
                return createNodeFromInputString(it)
            }
        }

        throw RuntimeException("Seems like there is no leaf node. Aborting..")
    }

    private fun getNodeNameFromParsedString(s: String): String {
        return s.split(" ")[0]
    }

    private fun getNodeWeightFromParsedString(s: String): Int {
        return s.split(" ")[1].removeSurrounding("(", ")").toInt()
    }

    private fun createNodeFromInputString(input: String): Node {
        val name = input.split(" ")[0]
        val weight = input.split(" ")[1].removeSurrounding("(", ")").toInt()

        return Node(name, weight, mutableListOf(), mutableListOf())
    }
}