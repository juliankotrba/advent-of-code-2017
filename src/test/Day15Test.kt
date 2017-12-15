import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 15
 * @author Julian Kotrba
 *
 */
class Day15Test {

    private val d = Day15()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val result = d.calcPart1(Generator(65, 16807L), Generator(8921, 48271L))
        Assert.assertEquals(588, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val result = d.calcPart2(Generator(65, 16807L), Generator(8921, 48271L))
        Assert.assertEquals(309, result)
    }

}
