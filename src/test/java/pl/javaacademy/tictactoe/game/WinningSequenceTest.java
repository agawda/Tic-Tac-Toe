package pl.javaacademy.tictactoe.game;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WinningSequenceTest {
    @DataProvider(name = "testValueSet")
    public Object[][] testData() {
        return new Object[][] {
                {1, 1},
                {1000, 1000},
                {13414, 13414}
        };
    }

    @Test(dataProvider = "testValueSet")
    public void checkSameValuesReturnedTest(int passed, Integer expected) {
        WinningSequence winningSequence = new WinningSequence(passed);
        Integer actual = winningSequence.intValue();
        assertEquals(actual, expected);
    }
}
