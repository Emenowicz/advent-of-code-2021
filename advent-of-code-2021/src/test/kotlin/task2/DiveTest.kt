package task2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

private const val _TEST_INPUT_TXT = "/task2/testInput.txt"

internal class DiveTest {

    private val dive = Dive()

    @Test
    fun testPart1() {
        //given
        val expectedResult = 150
        //when
        val result = dive.calculatePart1(dive.getInputData(_TEST_INPUT_TXT))
        //then
        assertEquals(expectedResult, result)
    }

    @Test
    fun testPart2() {
        //given
        val expectedResult = 900
        //when
        val result = dive.calculatePart2(dive.getInputData(_TEST_INPUT_TXT))
        //then
        assertEquals(expectedResult, result)
    }
}