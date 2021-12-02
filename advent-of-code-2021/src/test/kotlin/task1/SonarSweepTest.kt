package task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SonarSweepTest {

    private val sonarSweep: SonarSweep = SonarSweep()

    @Test
    fun testSonarSweep() {
        //given
        val expectedResult = 7
        //when
        val result = sonarSweep.calculateDepth("/testInput.txt");
        //then
        assertEquals(expectedResult, result)
    }
}