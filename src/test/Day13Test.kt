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

        val input = listOf(Area(0, 3), Area(1, 2), Area(4, 4), Area(6, 4))

        val result = d.calcPart1(input)
        Assert.assertEquals(24, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val input = listOf(Area(0, 3), Area(1, 2), Area(4, 4), Area(6, 4))

        val result = d.calcPart2(input)
        Assert.assertEquals(10, result)
    }

}
