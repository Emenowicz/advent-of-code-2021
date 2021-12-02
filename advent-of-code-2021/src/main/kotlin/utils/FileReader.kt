package utils

class  FileReader {
    companion object{
        @JvmStatic
        fun readFileAsList(fileName: String): List<String> {
            return this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.readLines() ?: emptyList()
        }
    }
}