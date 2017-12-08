import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 2
 * @author Julian Kotrba
 *
 * Example part 1:
 * 5 1 9 5
 * 7 5 3
 * 2 4 6 8
 *
 * The first row's largest and smallest values are 9 and 1, and their difference is 8.
 * The second row's largest and smallest values are 7 and 3, and their difference is 4.
 * The third row's difference is 6.
 * In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
 *
 * Example part 2:
 *
 * 5 9 2 8
 * 9 4 7 3
 * 3 8 6 5
 *
 * In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
 * In the second row, the two numbers are 9 and 3; the result is 3.
 * In the third row, the result is 2.
 * In this example, the sum of the results would be 4 + 3 + 2 = 9.
 *
 */
class Day2Test {

    private val d = Day2()

    @Test
    fun `Test example one`() {

        val row1 = listOf(5, 1, 9, 5)
        val row2 = listOf(7, 5, 3)
        val row3 = listOf(2, 4, 6, 8)

        val input = listOf(row1, row2, row3)

        val result = d.calcPart1(input)
        Assert.assertEquals(18, result)
    }

    @Test
    fun `Test example two`() {

        val row1 = listOf(5, 9, 2, 8)
        val row2 = listOf(9, 4, 7, 3)
        val row3 = listOf(3, 8, 6, 5)

        val input = listOf(row1, row2, row3)

        val result = d.calcPart2(input)
        Assert.assertEquals(9, result)
    }





}