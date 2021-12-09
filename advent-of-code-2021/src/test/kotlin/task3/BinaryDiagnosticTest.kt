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

    @Test
    fun testPart2() {
        //given
        val expectedResult = 230
        //when
        val result = binaryDiagnostic.calculatePart2(binaryDiagnostic.getInputData("/task3/testInput.txt"))
        //then
        assertEquals(expectedResult, result)
    }
}