/**
 * Day three of Advent of Code 2017
 * @author Julian Kotrba
 */

class Day3 {


    fun calcPart1() {

        /*
             Ulam-Spiral:

             Solved it without code.
             Basically what I did is finding the first bottom right value which is greater than the input value
             with calculating the square value of all odd numbers.
             539^2 = 290521. So now we also know that there are 539 values in this row.
             289983 X X X .. 290521 --> input value not between so we go up.

             289445
               X
               X
              ...
             289983   --> input value not between so we look in the "first row" top left corner till top right corner

             289445 X X .. 288907 --> Yes, value is between.
             Now we just have to measure the distance to the middle and calculate the distance to the middle value of
             the square:  269+150 = 419

             Shouldn't be hard to write the algorithm in Kotlin
         */
    }

    fun calcPart2() {

        // Too lazy for implementing the spiral calculation
        // Found the sequence on https://oeis.org/
        // Sorry for cheating 🤷‍‍️

    }

}