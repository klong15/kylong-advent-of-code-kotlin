import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()

        input.forEach {
            var result = it.split(regex = "\\s+".toRegex())
            leftList.add(result[0].toInt())
            rightList.add(result[1].toInt())
        }

        leftList.sort()
        rightList.sort();

        var distance = 0
        for(i in leftList.indices) {
            distance += abs(leftList[i] - rightList[i])
        }

        return distance
    }

    fun part2(input: List<String>): Int {
        val leftMap = mutableMapOf<Int, Int>()
        val rightMap = mutableMapOf<Int, Int>()

        input.forEach {
            val result = it.split(regex = "\\s+".toRegex())
            val leftValue = result[0].toInt()
            val rightValue = result[1].toInt()
            leftMap.merge(leftValue, 1, Int::plus)
            rightMap.merge(rightValue, 1, Int::plus)
        }
        var total = 0;
        leftMap.forEach {
            total += it.key * (rightMap[it.key] ?: 0) * it.value
        }

        return total
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
