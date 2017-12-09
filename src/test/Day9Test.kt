import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 9
 * @author Julian Kotrba
 *
 * Example part 1:
 *
 * Your goal is to find the total score for all groups in your input. Each group is assigned a score which is one more than the score of the group that immediately contains it. (The outermost group gets a score of 1.)
 *
 * {}, score of 1.
 * {{{}}}, score of 1 + 2 + 3 = 6.
 * {{},{}}, score of 1 + 2 + 2 = 5.
 * {{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.
 * {<a>,<a>,<a>,<a>}, score of 1.
 * {{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
 * {{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
 * {{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3.
 *
 *
 * Example part 2:
 *
 * Now, you're ready to remove the garbage.
 * To prove you've removed it, you need to count all of the characters within the garbage. The leading and trailing < and > don't count, nor do any canceled characters or the ! doing the canceling.
 *
 * <>, 0 characters.
 * <random characters>, 17 characters.
 * <<<<>, 3 characters.
 * <{!>}>, 2 characters.
 * <!!>, 0 characters.
 * <!!!>>, 0 characters.
 * <{o"i!a,<{i<a>, 10 characters.
 */
class Day9Test {

    private val d = Day9()

    /**
     * Part one
     */

    @Test
    fun `Test example one`() {
        val input = "{}"

        val result = d.calcPart1(input)
        Assert.assertEquals(1, result)
    }

    @Test
    fun `Test example two`() {
        val input = "{{{}}}"

        val result = d.calcPart1(input)
        Assert.assertEquals(6, result)
    }


    @Test
    fun `Test example three`() {
        val input = "{{},{}}"

        val result = d.calcPart1(input)
        Assert.assertEquals(5, result)
    }

    @Test
    fun `Test example four`() {
        val input = "{{{},{},{{}}}}"

        val result = d.calcPart1(input)
        Assert.assertEquals(16, result)
    }

    @Test
    fun `Test example five`() {
        val input = "{<a>,<a>,<a>,<a>}"

        val result = d.calcPart1(input)
        Assert.assertEquals(1, result)
    }

    @Test
    fun `Test example six`() {
        val input = "{{<ab>},{<ab>},{<ab>},{<ab>}}"

        val result = d.calcPart1(input)
        Assert.assertEquals(9, result)
    }

    @Test
    fun `Test example seven`() {
        val input = "{{<!!>},{<!!>},{<!!>},{<!!>}}"

        val result = d.calcPart1(input)
        Assert.assertEquals(9, result)
    }

    @Test
    fun `Test example eight`() {
        val input = "{{<a!>},{<a!>},{<a!>},{<ab>}}"

        val result = d.calcPart1(input)
        Assert.assertEquals(3, result)
    }

    /**
     * Part two
     */

    @Test
    fun `Test example nine`() {
        val input = "<>"

        val result = d.calcPart2(input)
        Assert.assertEquals(0, result)
    }

    @Test
    fun `Test example ten`() {
        val input = "<random characters>"

        val result = d.calcPart2(input)
        Assert.assertEquals(17, result)
    }

    @Test
    fun `Test example eleven`() {
        val input = "<<<<>"

        val result = d.calcPart2(input)
        Assert.assertEquals(3, result)
    }

    @Test
    fun `Test example twelve`() {
        val input = "<{!>}>"

        val result = d.calcPart2(input)
        Assert.assertEquals(2, result)
    }

    @Test
    fun `Test example thirteen`() {
        val input = "<!!>"

        val result = d.calcPart2(input)
        Assert.assertEquals(0, result)
    }

    @Test
    fun `Test example fourteen`() {
        val input = "<!!!>>"

        val result = d.calcPart2(input)
        Assert.assertEquals(0, result)
    }

    @Test
    fun `Test example fifteen`() {
        val input = "<{o\"i!a,<{i<a>"

        val result = d.calcPart2(input)
        Assert.assertEquals(10, result)
    }



}
