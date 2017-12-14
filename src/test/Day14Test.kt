import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 14
 * @author Julian Kotrba
 *
 */
class Day14Test {

    private val d = Day14()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val result = d.calcPart1("flqrgnkx")
        Assert.assertEquals(8108, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val result = d.calcPart2("flqrgnkx")
        Assert.assertEquals(1242, result)
    }

}
