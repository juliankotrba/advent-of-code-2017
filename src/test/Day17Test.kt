import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 17
 * @author Julian Kotrba
 *
 *
 */
class Day17Test {

    private val d = Day17()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {
        val input = 3

        val result = d.calcPart1(input)
        Assert.assertEquals(638, result)
    }

}
