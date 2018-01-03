import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 22
 * @author Julian Kotrba
 *
 *
 */
class Day24Test {

    private val d = Day24()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val input = mutableListOf(
                Pair(0, 2),
                Pair(2, 2),
                Pair(2, 3),
                Pair(3, 4),
                Pair(3, 5),
                Pair(0, 1),
                Pair(10, 1),
                Pair(9, 10)
        )

        val result = d.calcPart1(input)
        Assert.assertEquals(31, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val input = mutableListOf(
                Pair(0, 2),
                Pair(2, 2),
                Pair(2, 3),
                Pair(3, 4),
                Pair(3, 5),
                Pair(0, 1),
                Pair(10, 1),
                Pair(9, 10)
        )

        val result = d.calcPart2(input)
        Assert.assertEquals(19, result)
    }


}
