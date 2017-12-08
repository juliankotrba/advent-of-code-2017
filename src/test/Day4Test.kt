import org.junit.Assert
import org.junit.Test

/**
 * Tests for day 4
 * @author Julian Kotrba
 *
 * Example part 1: A valid passphrase must contain no duplicate words.
 *
 * aa bb cc dd ee is valid.
 * aa bb cc dd aa is not valid - the word aa appears more than once.
 * aa bb cc dd aaa is valid - aa and aaa count as different words.
 *
 * Example part 2: a passphrase is invalid if any word's letters can be rearranged to form
 *                 any other word in the passphrase.
 *
 * abcde fghij is a valid passphrase.
 * abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
 * a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
 * iiii oiii ooii oooi oooo is valid.
 * oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
 *
 */
class Day4Test {

    private val d = Day4()

    @Test
    fun `Test example one`() {
        val phrase1 = listOf("aa", "bb", "cc", "dd", "ee")
        val phrase2 = listOf("aa", "bb", "cc", "dd", "aa")
        val phrase3 = listOf("aa", "bb", "cc", "dd", "aaa")

        val input = listOf(phrase1, phrase2, phrase3)

        val result = d.calcPart1(input)
        Assert.assertEquals(2, result)
    }

    @Test
    fun `Test example two`() {
        val phrase1 = listOf("abcde", "fghij")
        val phrase2 = listOf("abcde", "xyz", "ecdab")
        val phrase3 = listOf("a", "ab", "abc", "abd", "abf", "abj")
        val phrase4 = listOf("iiii", "oiii", "ooii", "oooi", "oooo")
        val phrase5 = listOf("oiii", "ioii", "iioi", "iiio")

        val input = listOf(phrase1, phrase2, phrase3, phrase4, phrase5)

        val result = d.calcPart2(input)
        Assert.assertEquals(3, result)
    }

}