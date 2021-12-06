package task3

import task0.Problem

class BinaryDiagnostic : Problem {
    override fun printSolution() {
        println("Part 1: " + calculatePart1(getInputData("/task3/part1/input.txt")))
//        println("Part 2: " + calculatePart2(getInputData("/task3/part2/input.txt")))
    }

    fun calculatePart1(data: List<String>): Int {
        val matrix = data.map { it -> it.toList() }
        val rows = matrix.size
        val columns = matrix[0].size
        val gammaRateBitsList = ArrayList<String>()
        val epsilonRateBitsList = ArrayList<String>()

        val transposedMatrix = Array(columns) { Array(rows) { "it = $it" } }
        for (i in 0 until rows) {
            for (j in 0 until columns)
                transposedMatrix[j][i] = matrix[i][j].toString()
        }

        transposedMatrix.forEach { row ->
            val bitsCounted = row.groupingBy { it }.eachCount()
            val gammaBit = bitsCounted.maxByOrNull { it.value }?.key
            val epsilonBit = bitsCounted.minByOrNull { it.value }?.key
            if (gammaBit != null && epsilonBit != null) {
                gammaRateBitsList.add(gammaBit)
                epsilonRateBitsList.add(epsilonBit)
            }
        }

        val gammaRate = gammaRateBitsList.joinToString("").toInt(2)
        val epsilonRate = epsilonRateBitsList.joinToString("").toInt(2)
        return gammaRate * epsilonRate;
    }
}