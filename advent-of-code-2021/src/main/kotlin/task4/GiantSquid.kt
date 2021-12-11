package task4

import task0.Problem
import utils.MatrixUtils

private const val DOUBLE_SPACE = "  "
private const val SPACE = " "

class GiantSquid : Problem {
    var winningSum = 0

    override fun printSolution() {
        println("Part 1: " + calculatePart1(getInputData("/task4/part1/input.txt")))
//        println("Part 2: " + calculatePart2(getInputData("/task4/part2/input.txt")))
    }

    fun calculatePart1(data: List<String>): Int {
        val numbers = getNumbers(data)
        val matrixesList = parseData(data.subList(2, data.size))

        val numbersCalled = ArrayList<Int>()


        numbers.forEach { number ->
            numbersCalled.add(number)
            checkWinner(matrixesList, numbersCalled)
            if (winningSum > 0) {
                return winningSum
            }
        }

        return 0
    }

    private fun checkWinner(matrixesList: List<Array<Array<Int>>>, numbersCalled: ArrayList<Int>) {
        matrixesList.forEachIndexed { index, matrix ->

            val transposedMatrix = MatrixUtils.transposeIntMatrix(matrix)
            matrix.plus(transposedMatrix).forEach { row ->
                if (row.all { number -> numbersCalled.contains(number) }) {
                    winningSum = matrix.flatten().filter { number -> !numbersCalled.contains(number) }
                        .sum() * numbersCalled.last()
                    return
                }
            }
        }
    }

    private fun getNumbers(data: List<String>): List<Int> {
        return data[0].split(",").map { number -> number.toInt() }
    }

    private fun parseData(data: List<String>): List<Array<Array<Int>>> {
        val matrixesList = ArrayList<Array<Array<Int>>>()
        var currentMatrix = initializeNewMatrix()
        var currentMatrixLine = 0
        data.forEach { line ->
            if (line.isNotBlank()) {
                val row = line.trim().replace(DOUBLE_SPACE, SPACE).split(SPACE)
                row.forEachIndexed { index, s ->
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