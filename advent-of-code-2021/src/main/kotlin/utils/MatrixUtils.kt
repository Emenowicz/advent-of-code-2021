package utils

class MatrixUtils {
    companion object {
        @JvmStatic
        fun transposeCharMatrix(matrix: List<List<Char>>): Array<Array<String>> {
            val rows = matrix.size
            val columns = matrix[0].size
            val transposedMatrix = Array(columns) { Array(rows) { "it = $it" } }
            for (i in 0 until rows) {
                for (j in 0 until columns) transposedMatrix[j][i] = matrix[i][j].toString()
            }
            return transposedMatrix
        }

        @JvmStatic
        fun transposeIntMatrix(matrix: Array<Array<Int>>): Array<Array<Int>> {
            val rows = matrix.size
            val columns = matrix[0].size
            val transposedMatrix = Array(columns) { Array(rows) { 0 } }
            for (i in 0 until rows) {
                for (j in 0 until columns) transposedMatrix[j][i] = matrix[i][j]
            }
            return transposedMatrix
        }

    }
}