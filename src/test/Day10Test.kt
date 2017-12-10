import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 10
 * @author Julian Kotrba
 *
 * Example part 1:

 */
class Day10Test {

    private val d = Day10()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {
        val listOfNumbers = (0 .. 4).toMutableList()
        val sequenceOfLengths = listOf(3, 4, 1, 5)

        println(listOfNumbers)

        val result = d.calcPart1(listOfNumbers, sequenceOfLengths.toMutableList())
        Assert.assertEquals(12, result)
    }


    /**
     * Part two
     */

    @Test
    fun `Test example two`() {
        val listOfNumbers = (0 .. 255).toMutableList()
        //val sequenceOfLengths = "192,69,168,160,78,1,166,28,0,83,198,2,254,255,41,12"
        val sequenceOfLengths = ""


        val result = d.calcPart2(listOfNumbers, sequenceOfLengths)
        Assert.assertEquals("a2582a3a0e66e6e86e3812dcb672a272", result)
    }

    @Test
    fun `Test example three`() {
        val listOfNumbers = (0 .. 255).toMutableList()
        val sequenceOfLengths = "AoC 2017"


        val result = d.calcPart2(listOfNumbers, sequenceOfLengths)
        Assert.assertEquals("33efeb34ea91902bb2f59c9920caa6cd", result)
    }

    @Test
    fun `Test example four`() {
        val listOfNumbers = (0 .. 255).toMutableList()
        val sequenceOfLengths = "1,2,3"


        val result = d.calcPart2(listOfNumbers, sequenceOfLengths)
        Assert.assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", result)
    }

    @Test
    fun `Test example five`() {
        val listOfNumbers = (0 .. 255).toMutableList()
        val sequenceOfLengths = "1,2,4"


        val result = d.calcPart2(listOfNumbers, sequenceOfLengths)
        Assert.assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", result)
    }


}
