import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 21
 * @author Julian Kotrba
 *
 *
 */
class Day21Test {

    private val d = Day21()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val input = listOf(
                "../.# => ##./#../...",
                ".#./..#/### => #..#/..../..../#..#"
        )

        val result = d.calcPart1(input)
        Assert.assertEquals(12, result)
    }


}
