import java.io.File
import kotlin.system.measureTimeMillis

/**
 * Created by Julian Kotrba on 01.12.17.
 */

fun main(args: Array<String>) {
    //day1()
    //day2()
    //day4()
    //day5()
    //day6()
    //day7()
    //day8()
    day9()
}

private fun day1() {
    val d = Day1()

    val inputAsString = "5255443714755555317777152441826784321918285999594221531636242944998363716119294845838579943562543247239969555791772392681567883449837982119239536325341263524415397123824358467891963762948723327774545715851542429832119179139914471523515332247317441719184556891362179267368325486642376685657759623876854958721636574219871249645773738597751429959437466876166273755524873351452951411628479352522367714269718514838933283861425982562854845471512652555633922878128558926123935941858532446378815929573452775348599693982834699757734714187831337546474515678577158721751921562145591166634279699299418269158557557996583881642468274618196335267342897498486869925262896125146867124596587989531495891646681528259624674792728146526849711139146268799436334618974547539561587581268886449291817335232859391493839167111246376493191985145848531829344198536568987996894226585837348372958959535969651573516542581144462536574953764413723147957237298324458181291167587791714172674717898567269547766636143732438694473231473258452166457194797819423528139157452148236943283374193561963393846385622218535952591588353565319432285579711881559343544515461962846879685879431767963975654347569385354482226341261768547328749947163864645168428953445396361398873536434931823635522467754782422557998262858297563862492652464526366171218276176258582444923497181776129436396397333976215976731542182878979389362297155819461685361676414725597335759976285597713332688275241271664658286868697167515329811831234324698345159949135474463624749624626518247831448143876183133814263977611564339865466321244399177464822649611969896344874381978986453566979762911155931362394192663943526834148596342268321563885255765614418141828934971927998994739769141789185165461976425151855846739959338649499379657223196885539386154935586794548365861759354865453211721551776997576289811595654171672259129335243531518228282393326395241242185795828261319215164262237957743232558971289145639852148197184265766291885259847236646615935963759631145338159257538114359781854685695429348428884248972177278361353814766653996675994784195827214295462389532422825696456457332417366426619555"
    val inputAsList: List<Int> = inputAsString.toIntList()

    val time = measureTimeMillis {
        println("Result: ${d.calc(inputAsList)}")
    }
    println("time in millis: $time")

}

private fun day2() {
    val d = Day2()
    val input = parseInput("src/main/day2/input", ListOfListOfIntParser("\t"))

    val time = measureTimeMillis {
        println("Result: ${d.calcPart2(input)}")
    }
    println("time in millis: $time")
}

private fun day4() {
    val d = Day4()
    val input = parseInput("src/main/day4/input", ListOfListOfStringParser(" "))

    val time = measureTimeMillis {
        println("Result: ${d.calcPart2(input)}")
    }
    println("time in millis: $time")
}

private fun day5() {
    val d = Day5()
    val input = parseInput("src/main/day5/input", ListOfIntParser()).toMutableList()

    val time = measureTimeMillis {
        println("Result: ${d.calcPart2(input)}")
    }
    println("time in millis: $time")
}

private fun day6() {
    val d = Day6()
    val input = mutableListOf(4, 10, 4, 1, 8, 4, 9, 14 ,5 ,1 ,14, 15, 0, 15, 3, 5)

    val time = measureTimeMillis {
        println("Result: ${d.calcPart2(input)}")
    }
    println("time in millis: $time")
}

private fun day7() {
    val d = Day7()
    val input = parseInput("src/main/day7/input", ListOfStringParser())

    val time = measureTimeMillis {
        d.calcPart2(input)
    }
    println("time in millis: $time")
}

private fun day8() {
    val d = Day8()
    val input = parseInput("src/main/day8/input", ListOfStringParser())

    val time = measureTimeMillis {
        println("Result: ${d.calcPart2(input)}")
    }
    println("time in millis: $time")
}

private fun day9(){
    val d = Day9()
    val input = parseInput("src/main/day9/input", OneRowAsStringParser())

    val time = measureTimeMillis {
        println("Result: ${d.calcPart2(input)}")
    }
    println("time in millis: $time")

}

interface RowParser<out T> {
    fun parse(rows: List<String>): T
}

class ListOfIntParser: RowParser<List<Int>> {

    override fun parse(rows: List<String>): List<Int> {
        val input = mutableListOf<Int>()
        rows.forEach {
            input.add(Integer.parseInt(it))
        }
        return input
    }
}

class ListOfStringParser: RowParser<List<String>> {
    override fun parse(rows: List<String>): List<String> {
        val input = mutableListOf<String>()
        rows.forEach {
            input.add(it)
        }
        return input
    }
}

class OneRowAsStringParser: RowParser<String> {
    override fun parse(rows: List<String>): String {
        val input = mutableListOf<String>()
        rows.forEach {
            input.add(it)
        }
        return rows.get(0)
    }
}

class ListOfListOfIntParser(private val delimiter: String): RowParser<List<List<Int>>> {

    override fun parse(rows: List<String>): List<List<Int>> {
        val input = mutableListOf<List<Int>>()
        rows.forEach {
            val listOfInt = mutableListOf<Int>()
            it.split(delimiter).forEach({ s ->
                listOfInt.add(s.toInt())
            })
            input.add(listOfInt)
        }

        return input
    }
}

class ListOfListOfStringParser(private val delimiter: String): RowParser<List<List<String>>> {

    override fun parse(rows: List<String>): List<List<String>> {
        val input = mutableListOf<List<String>>()
        rows.forEach {
            val listOfInt = mutableListOf<String>()
            it.split(delimiter).forEach({ s ->
                listOfInt.add(s)
            })
            input.add(listOfInt)
        }
        return input
    }
}

private fun <T>parseInput(filePath: String, rowParser: RowParser<T>): T {
    return rowParser.parse(readFileLineByLine(filePath))
}

private fun readFileLineByLine(filePath: String): List<String> {
    val f = File(filePath)
    return f.readLines()
}

private fun String.toIntList(): List<Int> = this.map { it.minus('0') }

