package task1

import task0.Problem
import utils.FileReader

class SonarSweep : Problem {

    override fun printSolution() {
        println("Part 1: " + calculatePart1("/task1/part1/input.txt"))
        println("Part 2: " + calculatePart2("/task1/part2/input.txt"))
    }

    fun calculatePart1(fileName: String): Int {
        val measurements = FileReader.readFileAsList(fileName).map { it.toInt() }
        return findCountOfBiggerThanPredecessor(measurements)
    }

    fun calculatePart2(fileName: String): Int {
        val measurements = FileReader.readFileAsList(fileName)
        return findCountOfBiggerThanPredecessor(measurements.map { it.toInt() }.windowed(3).map { window -> window.sum() })
    }

    private fun findCountOfBiggerThanPredecessor(measurements: List<Int>): Int {
        return measurements.filterIndexed { index, value -> if (index < measurements.size - 1) value < measurements[index + 1] else false }
            .count()
    }
}