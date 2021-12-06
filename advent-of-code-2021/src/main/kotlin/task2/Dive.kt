package task2

import task0.Problem

private const val SPACE = ' '

class Dive : Problem {
    override fun printSolution() {
        println("Part 1: " + calculatePart1(getInputData("/task2/part1/input.txt")))
        println("Part 2: " + calculatePart2(getInputData("/task2/part2/input.txt")))
    }

    fun calculatePart1(data: List<String>): Int {
        var x = 0
        var y = 0
        val inputData = convertInputToTuples(data)
        inputData.forEach {
            val command = it[0]
            val value = it[1].toInt()
            when (command) {
                "forward" -> x += value
                "down" -> y += value
                "up" -> y -= value
            }
        }
        return x * y
    }

    fun calculatePart2(data: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0
        val inputData = convertInputToTuples(data)
        inputData.forEach {
            val command = it[0]
            val value = it[1].toInt()
            when (command) {
                "forward" -> {
                    x += value
                    y += (aim * value)
                }
                "down" -> aim += value
                "up" -> aim -= value
            }
        }
        return x * y
    }

    private fun convertInputToTuples(data: List<String>): List<List<String>> {
        return data.map { line -> line.trim().split(SPACE) }.toList()
    }
}