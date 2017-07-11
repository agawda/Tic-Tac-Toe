package pl.javaacademy.tictactoe.io;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.javaacademy.tictactoe.game.Mark;

import static org.testng.Assert.assertEquals;

public class MarkInputTest {
    @DataProvider(name = "testDataOk")
    public Object[][] testData() {
        return new Object[][] {
                {"X", Mark.X},
                {"O", Mark.O}
        };
    }

    @DataProvider(name = "testDataNotOk")
    public Object[][] wrongTestData() {
        return new Object[][] {
                {"asdasd"}
        };
    }

    @Test(dataProvider = "testDataOk")
    public void marksGeneratedProperlyTest(String given, Mark expected) {
        MarkInput markInput = new MarkInput();

        Mark actual = markInput.castUserInput(given);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "testDataNotOk", expectedExceptions = IllegalArgumentException.class)
    public void exceptionThrownWithWrongData(String given) {
        MarkInput markInput = new MarkInput();
        markInput.castUserInput(given);
    }


}
