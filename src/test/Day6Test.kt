import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 6
 * @author Julian Kotrba
 *
 * Example part 1 with input [0 2 7 0]
 *
 * The banks start with 0, 2, 7, and 0 blocks. The third bank has the most blocks, so it is chosen for redistribution.
 * Starting with the next bank (the fourth bank) and then continuing to the first bank, the second bank, and so on, the
 * 7 blocks are spread out over the memory banks. The fourth, first, and second banks get two blocks each, and the third
 * bank gets one back. The final result looks like this: 2 4 1 2.
 * Next, the second bank is chosen because it contains the most blocks (four). Because there are four memory banks, each
 * gets one block. The result is: 3 1 2 3.
 * Now, there is a tie between the first and fourth memory banks, both of which have three blocks. The first bank wins
 * the tie, and its three blocks are distributed evenly over the other three banks, leaving it with none: 0 2 3 4.
 * The fourth bank is chosen, and its four blocks are distributed such that each of the four banks receives one: 1 3 4 1.
 * The third bank is chosen, and the same thing happens: 2 4 1 2.
 * At this point, we've reached a state we've seen before: 2 4 1 2 was already seen. The infinite loop is detected after
 * the fifth block redistribution cycle, and so the answer in this example is 5.
 *
 * Example part 2 with same input
 *
 * Out of curiosity, the debugger would also like to know the size of the loop: starting from a state that has already
 * been seen, how many block redistribution cycles must be performed before that same state is seen again?
 * In the example above, 2 4 1 2 is seen again after four cycles, and so the answer in that example would be 4.
 *
 */
class Day6Test {

    private val d = Day6()

    @Test
    fun `Test example one`() {
        val input = mutableListOf(0, 2, 7, 0)

        val result = d.calcPart1Optimized(input)
        Assert.assertEquals(5, result)
    }

    @Test
    fun `Test example two`() {
        val input = mutableListOf(0, 2, 7, 0)

        val result = d.calcPart2(input)
        Assert.assertEquals(4, result)
    }

}