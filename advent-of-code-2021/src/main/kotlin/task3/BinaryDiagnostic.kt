package task3

import task0.Problem
import utils.MatrixUtils

class BinaryDiagnostic : Problem {
    override fun printSolution() {
        println("Part 1: " + calculatePart1(getInputData("/task3/part1/input.txt")))
        println("Part 2: " + calculatePart2(getInputData("/task3/part2/input.txt")))
    }

    fun calculatePart1(data: List<String>): Int {
        val matrix = data.map { it -> it.toList() }

        val gammaRateBitsList = ArrayList<String>()
        val epsilonRateBitsList = ArrayList<String>()

        val transposedMatrix = MatrixUtils.transposeCharMatrix(matrix)

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
        return gammaRate * epsilonRate
    }

    fun calculatePart2(data: List<String>): Int {

        val matrix = data.map { it -> it.toList() }
        val transposedMatrix = MatrixUtils.transposeCharMatrix(matrix)

        val ignoredMaxIndices = HashSet<Int>()
        val ignoredMinIndices = HashSet<Int>()

        transposedMatrix.forEach { row ->
            val bitsCountedFilteredByMaxIndices =
                row.filterIndexed { index, _ -> !ignoredMaxIndices.contains(index) }.groupingBy { it }.eachCount()
            val bitsCountedFilteredByMinIndices =
                row.filterIndexed { index, _ -> !ignoredMinIndices.contains(index) }.groupingBy { it }.eachCount()

            val maxBit =
                bitsCountedFilteredByMaxIndices.toSortedMap(Comparator.reverseOrder()).maxByOrNull { it.value }?.key
            val minBit = bitsCountedFilteredByMinIndices.toSortedMap().minByOrNull { it.value }?.key
            row.forEachIndexed { index, s ->
                if (s != maxBit) {
                    ignoredMaxIndices.add(index)
                }
                if (s != minBit) {
                    ignoredMinIndices.add(index)
                }
            }
        }

        val oxygenGenerationRating = data.filterIndexed { index, _ -> !ignoredMaxIndices.contains(index) }[0].toInt(2)
        val co2ScrubberRating = data.filterIndexed { index, _ -> !ignoredMinIndices.contains(index) }[0].toInt(2)

        return oxygenGenerationRating * co2ScrubberRating
    }


}