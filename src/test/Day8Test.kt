import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 8
 * @author Julian Kotrba
 *
 */
class Day8Test {

    private val d = Day8()

    @Test
    fun `Test example one`() {
        val row1 = "b inc 5 if a > 1"
        val row2 = "a inc 1 if b < 5"
        val row3 = "c dec -10 if a >= 1"
        val row4 = "c inc -20 if c == 10"
        val input = listOf(row1, row2, row3, row4)

        val result = d.calcPart1(input)
        Assert.assertEquals(1, result)
    }

    @Test
    fun `Test example two`() {
        val row1 = "b inc 5 if a > 1"
        val row2 = "a inc 1 if b < 5"
        val row3 = "c dec -10 if a >= 1"
        val row4 = "c inc -20 if c == 10"
        val input = listOf(row1, row2, row3, row4)

        val result = d.calcPart2(input)
        Assert.assertEquals(10, result)
    }

}