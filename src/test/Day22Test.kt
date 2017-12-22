import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 22
 * @author Julian Kotrba
 *
 *
 */
class Day22Test {

    private val d = Day22()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val input = mutableListOf(
                "..#".map { it }.toMutableList(),
                "#..".map { it }.toMutableList(),
                "...".map { it }.toMutableList()
        )

        val result = d.calcPart1(input)
        Assert.assertEquals(5587, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val input = mutableListOf(
                "..#".map { it }.toMutableList(),
                "#..".map { it }.toMutableList(),
                "...".map { it }.toMutableList()
        )

        val result = d.calcPart2(input)
        Assert.assertEquals(2511944, result)
    }


}
