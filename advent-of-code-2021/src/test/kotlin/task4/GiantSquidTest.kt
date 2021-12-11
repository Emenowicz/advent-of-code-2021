package task4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GiantSquidTest {
    private val giantSquid = GiantSquid()

    @Test
    fun testPart1() {
        //given
        val expectedResult = 4512
        //when
        val result = giantSquid.calculatePart1(giantSquid.getInputData("/task4/testInput.txt"))
        //then
        assertEquals(expectedResult, result)
    }

    @Test
    fun testPart2() {
        //given
        val expectedResult = 1924
        //when
        val result = giantSquid.calculatePart2(giantSquid.getInputData("/task4/testInput.txt"))
        //then
        assertEquals(expectedResult, result)
    }
}