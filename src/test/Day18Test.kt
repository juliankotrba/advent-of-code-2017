import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 18
 * @author Julian Kotrba
 *
 *
 */
class Day18Test {

    private val d = Day18()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {
        val input = listOf(
                "set a 1",
                "add a 2",
                "mul a a",
                "mod a 5",
                "snd a",
                "set a 0",
                "rcv a",
                "jgz a -1",
                "set a 1",
                "jgz a -2"
        )

        val result = d.calcPart1(input)
        Assert.assertEquals(4, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example two`() {
        val input = listOf(
                "snd 1",
                "snd 2",
                "snd p",
                "rcv a",
                "rcv b",
                "rcv c",
                "rcv d"
        )

        val result = d.calcPart2(input)
        Assert.assertEquals(4, result)
    }

}
