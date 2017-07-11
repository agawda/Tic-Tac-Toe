package pl.javaacademy.tictactoe.io;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

import static org.testng.Assert.assertEquals;

public class IntegerInputTest {
    @DataProvider(name = "isStringCastProperly")
    public Object[][] testData() {
        return new Object[][] {
                {"4", 4},
                {"23", 23}
        };
    }

    @Test(dataProvider = "isStringCastProperly")
    public void isStringCastProperlyTest(String given, Integer expected) {
        IntegerInput integerInput = new IntegerInput();

        Integer actual = integerInput.castUserInput(given);

        assertEquals(actual, expected);
    }
}
