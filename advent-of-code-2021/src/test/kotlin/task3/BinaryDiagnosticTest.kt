package task3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryDiagnosticTest{
private val binaryDiagnostic = BinaryDiagnostic()
    @Test
    fun testPart1() {
        //given
        val expectedResult = 198
        //when
        val result = binaryDiagnostic.calculatePart1(binaryDiagnostic.getInputData("/task3/testInput.txt"))
        //then
        assertEquals(expectedResult, result)
    }
}