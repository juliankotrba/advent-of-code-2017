import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 4
 * @author Julian Kotrba
 *
 * Example part 1 with input 0 3 0 1 -3
 *
 * (0) 3  0  1  -3  - before we have taken any steps.
 * (1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1.
 * 2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2.
 * 2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind.
 * 2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2.
 * 2  5  0  1  -2  - jump 4 steps forward, escaping the maze.
 *
 * Example part 2 with input 0 3 0 1 -3
 *
 * Now, the jumps are even stranger: after each jump, if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before.
 * Using this rule with the above example, the process now takes 10 steps, and the offset values after finding the exit are left as 2 3 2 3 -1.
 *
 */
class Day5Test {

    private val d = Day5()

    @Test
    fun `Test example one`() {
        val input = mutableListOf(0, 3, 0, 1, -3)

        val result = d.calcPart1(input)
        Assert.assertEquals(5, result)
    }

    @Test
    fun `Test example two`() {
        val input = mutableListOf(0, 3, 0, 1, -3)

        val result = d.calcPart2(input)
        Assert.assertEquals(10, result)
    }

}