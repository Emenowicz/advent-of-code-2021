package task1

import task0.Problem
import utils.FileReader

class SonarSweep : Problem {

    override fun printSolution() {
        println("Part 1: " + calculatePart1("/task1/input/input.txt"))
    }

    fun calculatePart1(fileName: String): Int {
        val measurements = FileReader.readFileAsList(fileName)
        return measurements
            .map { it.toInt() }
            .filterIndexed { index, value -> if (index < measurements.size - 1) value < measurements[index + 1].toInt() else false }
            .count()
    }

    fun calculatePart2(fileName: String): Int {
        TODO("Did not expect two parts")
    }
}