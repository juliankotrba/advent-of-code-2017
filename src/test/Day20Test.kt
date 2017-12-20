import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 20
 * @author Julian Kotrba
 *
 *
 */
class Day20Test {

    private val d = Day20()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val input = listOf(
                mutableListOf(3L,0L,0L,2L,0L,0L,-1L,0L,0L),
                mutableListOf(4L,0L,0L,0L,0L,0L,-2L,0L,0L)
        )


        val result = d.calcPart1(input)
        Assert.assertEquals(0, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {

        val input = mutableListOf(
                mutableListOf(-6L,0L,0L,3L,0L,0L,0L,0L,0L),
                mutableListOf(-4L,0L,0L,2L,0L,0L,0L,0L,0L),
                mutableListOf(-2L,0L,0L,1L,0L,0L,0L,0L,0L),
                mutableListOf(3L,0L,0L,-1L,0L,0L,0L,0L,0L)
        )


        val result = d.calcPart2(input)
        Assert.assertEquals(1, result)
    }

}
