package task4

import task0.Problem

private const val DOUBLE_SPACE = "  "
private const val SPACE = " "

class GiantSquid : Problem {
    override fun printSolution() {
        println("Part 1: " + calculatePart1(getInputData("/task4/part1/input.txt")))
//        println("Part 2: " + calculatePart2(getInputData("/task4/part2/input.txt")))
    }

    fun calculatePart1(data: List<String>): Int {
        val numbers = getNumbers(data)
        val matrixesList = parseData(data.subList(2, data.lastIndex))

        return 0
    }

    private fun getNumbers(data: List<String>): List<Int> {
        return data[0].split(",").map { number -> number.toInt() };
    }

    private fun parseData(data: List<String>): List<Array<Array<Int>>> {
        val matrixesList = ArrayList<Array<Array<Int>>>()
        var currentMatrix = initializeNewMatrix()
        var currentMatrixLine = 0
        data.forEachIndexed {index, line ->
            if (line.isNotBlank()) {
                val row = line.trim().replace(DOUBLE_SPACE, SPACE).split(SPACE)
                row.forEach {s ->
                    currentMatrix[currentMatrixLine][index] = s.toInt()
                }
                currentMatrixLine++
            } else {
                matrixesList.add(currentMatrix)
                currentMatrix = initializeNewMatrix()
                currentMatrixLine = 0
            }
        }
        matrixesList.add(currentMatrix)
        return matrixesList
    }

    private fun initializeNewMatrix(): Array<Array<Int>> {
        return Array(5) { Array(5) { 0 } }
    }
}