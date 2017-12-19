import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 19
 * @author Julian Kotrba
 *
 *
 */
class Day19Test {

    private val d = Day19()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {
        val input = listOf(
                "     |          ".map { it.toString() },
                "     |  +--+    ".map { it.toString() },
                "     A  |  C    ".map { it.toString() },
                " F---|----E|--+ ".map { it.toString() },
                "     |  |  |  D ".map { it.toString() },
                "     +B-+  +--+ ".map { it.toString() }

        )

        val result = d.calcPart1(input)
        Assert.assertEquals("ABCDEF", result)
    }

}
