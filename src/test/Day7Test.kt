import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 7
 * @author Julian Kotrba
 *
 * Example part 1
 *
 *
 *
 *
 */
class Day7Test {

    private val d = Day7()

    @Test
    fun `Test example one`() {

        val row1 = "pbga (66)"
        val row2 = "xhth (57)"
        val row3 = "ebii (61)"
        val row4 = "havc (66)"
        val row5 = "ktlj (57)"
        val row6 = "fwft (72) -> ktlj, cntj, xhth"
        val row7 = "qoyq (66)"
        val row8 = "padx (45) -> pbga, havc, qoyq"
        val row9 = "tknk (41) -> ugml, padx, fwft"
        val row10 = "jptl (61)"
        val row11 = "ugml (68) -> gyxo, ebii, jptl"
        val row12 = "gyxo (61)"
        val row13 = "cntj (57)"
        val input = listOf(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13)

        val root = d.calcPart1(input)

        Assert.assertEquals("tknk", root.name)
    }

    @Test // not really a test..
    fun `Test example two`() {
        val row1 = "pbga (66)"
        val row2 = "xhth (57)"
        val row3 = "ebii (61)"
        val row4 = "havc (66)"
        val row5 = "ktlj (57)"
        val row6 = "fwft (72) -> ktlj, cntj, xhth"
        val row7 = "qoyq (66)"
        val row8 = "padx (45) -> pbga, havc, qoyq"
        val row9 = "tknk (41) -> ugml, padx, fwft"
        val row10 = "jptl (61)"
        val row11 = "ugml (68) -> gyxo, ebii, jptl"
        val row12 = "gyxo (61)"
        val row13 = "cntj (57)"
        val input = listOf(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13)

        d.calcPart2(input)
    }

}