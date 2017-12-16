import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 16
 * @author Julian Kotrba
 *
 * For example, with only five programs standing in a line (abcde), they could do the following dance:
 *
 * s1, a spin of size 1: eabcd.
 * x3/4, swapping the last two programs: eabdc.
 * pe/b, swapping programs e and b: baedc.
 *
 */
class Day16Test {

    private val d = Day16()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val programs = (97 until 102).map { it.toChar().toString() }.toMutableList()
        println(programs)
        val commands = listOf("s1", "x3/4", "pe/b")

        val result = d.calcPart1(programs, commands)
        Assert.assertEquals(listOf("b", "a", "e", "d", "c"), result)
    }

}
