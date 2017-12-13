import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 13
 * @author Julian Kotrba
 *
 */
class Day13Test {

    private val d = Day13()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val input = listOf(3, 2, null, null, 4, null, 4)

        val result = d.calcPart1(input)
        Assert.assertEquals(24, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val input = listOf(3, 2, null, null, 4, null, 4)

        val result = d.calcPart2(input)
        Assert.assertEquals(10, result)
    }

}
