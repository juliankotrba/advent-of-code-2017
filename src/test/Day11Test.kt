import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 11
 * @author Julian Kotrba
 *
 * Example part 1:
 *
 * ne,ne,ne is 3 steps away.
 * ne,ne,sw,sw is 0 steps away (back where you started).
 * ne,ne,s,s is 2 steps away (se,se).
 * se,sw,se,sw,sw is 3 steps away (s,s,sw).
 *
 */
class Day11Test {

    private val d = Day11()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {
        val input = listOf("ne","ne","ne")

        val result = d.calcPart1(input)
        Assert.assertEquals(3, result)
    }

    @Test
    fun `Test example two`() {
        val input = listOf("ne","ne","sw", "sw")

        val result = d.calcPart1(input)
        Assert.assertEquals(0, result)
    }

    @Test
    fun `Test example three`() {
        val input = listOf("ne","s","s")

        val result = d.calcPart1(input)
        Assert.assertEquals(2, result)
    }

    @Test
    fun `Test example four`() {
        val input = listOf("se","sw","se", "sw", "sw")

        val result = d.calcPart1(input)
        Assert.assertEquals(3, result)
    }

}
