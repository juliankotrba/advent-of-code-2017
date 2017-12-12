import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 12
 * @author Julian Kotrba
 *
 * Example part 1:
 *
 */
class Day12Test {

    private val d = Day12()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val row1 = "0 <-> 2"
        val row2 = "1 <-> 1"
        val row3 = "2 <-> 0, 3, 4"
        val row4 = "3 <-> 2, 4"
        val row5 = "4 <-> 2, 3, 6"
        val row6 = "5 <-> 6"
        val row7 = "6 <-> 4, 5"
        val input = listOf(row1, row2, row3, row4, row5, row6, row7)

        val result = d.calcPart1(input)
        Assert.assertEquals(6, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val row1 = "0 <-> 2"
        val row2 = "1 <-> 1"
        val row3 = "2 <-> 0, 3, 4"
        val row4 = "3 <-> 2, 4"
        val row5 = "4 <-> 2, 3, 6"
        val row6 = "5 <-> 6"
        val row7 = "6 <-> 4, 5"
        val input = listOf(row1, row2, row3, row4, row5, row6, row7)

        val result = d.calcPart2(input)
        Assert.assertEquals(2, result)
    }

}
