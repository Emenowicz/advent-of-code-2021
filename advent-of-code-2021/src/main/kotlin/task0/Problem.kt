package task0

import utils.FileReader

interface Problem {
    fun printSolution()
    fun getInputData(filename: String): List<String> {
        return FileReader.readFileAsList(filename)
    }
}