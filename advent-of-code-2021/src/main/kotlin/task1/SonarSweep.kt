package task1

import task0.Problem

class SonarSweep : Problem {

    override fun printSolution() {
        println("Part 1: " + calculatePart1(getInputData("/task1/part1/input.txt")))
        println("Part 2: " + calculatePart2(getInputData("/task1/part2/input.txt")))
    }

    fun calculatePart1(data: List<String>): Int {
        return findCountOfBiggerThanPredecessor(data.map { it.toInt() })
    }

    fun calculatePart2(data: List<String>): Int {
        return findCountOfBiggerThanPredecessor(
            data.map { it.toInt() }.windowed(3).map { window -> window.sum() })
    }

    private fun findCountOfBiggerThanPredecessor(measurements: List<Int>): Int {
        return measurements.filterIndexed { index, value -> if (index < measurements.size - 1) value < measurements[index + 1] else false }
            .count()
    }
}