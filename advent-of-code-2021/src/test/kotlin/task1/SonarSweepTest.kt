package task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

private const val _TEST_INPUT_TXT = "/task1/testInput.txt"

internal class SonarSweepTest {

    private val sonarSweep: SonarSweep = SonarSweep()

    @Test
    fun testPart1() {
        //given
        val expectedResult = 7
        //when
        val result = sonarSweep.calculatePart1(sonarSweep.getInputData(_TEST_INPUT_TXT));
        //then
        assertEquals(expectedResult, result)
    }

    @Test
    fun testPart2() {
        //given
        val expectedResult = 5
        //when
        val result = sonarSweep.calculatePart2(sonarSweep.getInputData(_TEST_INPUT_TXT))
        //then
        assertEquals(expectedResult,result)
    }
}