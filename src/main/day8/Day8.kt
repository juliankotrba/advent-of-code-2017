/**
 * Day eight of Advent of Code 2017
 * @author Julian Kotrba
 *
 * A very long but imho clean solution
 * Naming is bad though
 */

class Day8 {

    fun calcPart1(input: List<String>): Int {
        val registerMap = mutableMapOf<String, Int>()

        input.map { rowToInst(it, registerMap) }
                .forEach {
                    if (it.relationalOperation.isTrue()) {
                        it.updateOperation.update()
                    }
                }

        return registerMap.values.max() ?: throw RuntimeException("No valid value in map")
    }

    fun calcPart2(input: List<String>): Int {
        var currentMax = Integer.MIN_VALUE
        val registerMap = mutableMapOf<String, Int>()

        input.map { rowToInst(it, registerMap) }
                .forEach {
                    if (it.relationalOperation.isTrue()) {
                        it.updateOperation.update()
                    }

                    if ((registerMap.values.max() ?: throw RuntimeException("No valid value in map")) > currentMax) {
                        currentMax = (registerMap.values.max() ?: throw RuntimeException("No valid value in map"))
                    }
                }

        return currentMax
    }

    private fun rowToInst(inputRow: String, instructionsMap: MutableMap<String, Int>): Instruction {
        val parts = inputRow.split(" ")
        val regName = parts[0]
        val changeWith = parts[2].toInt()

        val updateOperation: UpdateOperation = when (parts[1]) {
            "inc" -> IncOperation(regName, changeWith, instructionsMap)
            "dec" -> DecOperation(regName, changeWith, instructionsMap)
            else -> throw RuntimeException("Operation ${parts[1]} unknown.. ")
        }


        val checkRegister = parts[4]
        val checkWith = parts[6].toInt()
        val relationalOperation = when (parts[5]) {
            ">" -> GreaterOperation(checkRegister, checkWith, instructionsMap)
            ">=" -> GreaterEqualsOperation(checkRegister, checkWith, instructionsMap)
            "<" -> LessOperation(checkRegister, checkWith, instructionsMap)
            "<=" -> LessEqualsOperation(checkRegister, checkWith, instructionsMap)
            "==" -> EqualsOperation(checkRegister, checkWith, instructionsMap)
            "!=" -> NotEqualsOperation(checkRegister, checkWith, instructionsMap)
            else -> throw RuntimeException("Operation ${parts[5]} unknown.. ")
        }



        return Instruction(checkRegister, checkWith, updateOperation, relationalOperation)
    }

}

data class Instruction(
        val checkValue: String,
        val checkWith: Int,
        val updateOperation: UpdateOperation,
        val relationalOperation: RelationalOperation
)

interface UpdateOperation {
    fun update()
}

interface RelationalOperation {
    fun isTrue(): Boolean
}

class IncOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : UpdateOperation {

    override fun update() {

        val regValue = instructionsMap.getOrDefault(this.registerName, 0)
        val updatedRegValue = regValue + this.with
        instructionsMap.put(this.registerName, updatedRegValue)
    }

    override fun toString(): String {
        return "Increment operation: $registerName + $with "
    }
}

class DecOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : UpdateOperation {

    override fun update() {

        val regValue = instructionsMap.getOrDefault(this.registerName, 0)
        val updatedRegValue = regValue - this.with
        instructionsMap.put(this.registerName, updatedRegValue)
    }

    override fun toString(): String {
        return "Decrement operation: $registerName + $with "
    }
}

class EqualsOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : RelationalOperation {
    override fun isTrue(): Boolean {

        val regToCheckValue = instructionsMap.getOrDefault(registerName, 0)
        if (regToCheckValue == 0) instructionsMap.put(registerName, 0)


        return regToCheckValue == with
    }

    override fun toString(): String {
        return "Equals to operation: $registerName == $with "
    }
}

class NotEqualsOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : RelationalOperation {
    override fun isTrue(): Boolean {

        val regToCheckValue = instructionsMap.getOrDefault(registerName, 0)
        if (regToCheckValue == 0) instructionsMap.put(registerName, 0)

        return regToCheckValue != with
    }

    override fun toString(): String {
        return "Not equals to operation: $registerName == $with "
    }
}

class GreaterOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : RelationalOperation {
    override fun isTrue(): Boolean {

        val regToCheckValue = instructionsMap.getOrDefault(registerName, 0)
        if (regToCheckValue == 0) instructionsMap.put(registerName, 0)

        return regToCheckValue > with
    }

    override fun toString(): String {
        return "Greater than operation: $registerName == $with "
    }
}

class GreaterEqualsOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : RelationalOperation {
    override fun isTrue(): Boolean {

        val regToCheckValue = instructionsMap.getOrDefault(registerName, 0)
        if (regToCheckValue == 0) instructionsMap.put(registerName, 0)

        return regToCheckValue >= with
    }

    override fun toString(): String {
        return "Greater than or equal to operation: $registerName == $with "
    }
}

class LessEqualsOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : RelationalOperation {
    override fun isTrue(): Boolean {

        val regToCheckValue = instructionsMap.getOrDefault(registerName, 0)
        if (regToCheckValue == 0) instructionsMap.put(registerName, 0)

        return regToCheckValue <= with
    }

    override fun toString(): String {
        return "Less than or equal to operation: $registerName == $with "
    }
}

class LessOperation(private val registerName: String, private val with: Int, private val instructionsMap: MutableMap<String, Int>) : RelationalOperation {
    override fun isTrue(): Boolean {

        val regToCheckValue = instructionsMap.getOrDefault(registerName, 0)
        if (regToCheckValue == 0) instructionsMap.put(registerName, 0)

        return regToCheckValue < with
    }

    override fun toString(): String {
        return "Less than operation: $registerName == $with "
    }
}


