import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 1, part 2
 * @author Julian Kotrba
 *
 *
 * 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
 * 1221 produces 0, because every comparison is between a 1 and a 2.
 * 123425 produces 4, because both 2s match each other, but no other digit has a match.
 * 123123 produces 12.
 * 12131415 produces 4.
 *
 */
class Day1Test {

    private val d : Day1 = Day1()

    @Test
    fun `Test with provided test 1`() {
        val input = listOf<Int>(1, 2, 1, 2)

        val result = d.calc(input)
        Assert.assertEquals(6, result)
    }

    @Test
    fun `Test with provided test 2`() {
        val input = listOf<Int>(1, 2, 2, 1)

        val result = d.calc(input)
        Assert.assertEquals(0, result)
    }

    @Test
    fun `Test with provided test 3`() {
        val input = listOf<Int>(1, 2, 3, 4, 2, 5)

        val result = d.calc(input)
        Assert.assertEquals(4, result)
    }

    @Test
    fun `Test with provided test 4`() {
        val input = listOf<Int>(1, 2, 3, 1, 2, 3)

        val result = d.calc(input)
        Assert.assertEquals(12, result)
    }

    @Test
    fun `Test with provided test 5`() {
        val input = listOf<Int>(1, 2, 1, 3, 1, 4, 1, 5)

        val result = d.calc(input)
        Assert.assertEquals(4, result)
    }


}