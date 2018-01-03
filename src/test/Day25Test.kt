import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 22
 * @author Julian Kotrba
 *
 *
 */
class Day25Test {

    private val d = Day25()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {

        val state1 = State(0, 1, 1, 'B', 0, -1, 'B')
        val state2 = State(0, 1, -1, 'A', 1, 1, 'A')

        val states = mapOf(Pair('A', state1), Pair('B', state2))

        val result = d.calcPart1(states, 6)
        Assert.assertEquals(3, result)
    }

}
