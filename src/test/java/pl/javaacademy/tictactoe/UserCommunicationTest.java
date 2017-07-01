package pl.javaacademy.tictactoe;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.assertTrue;

public class UserCommunicationTest {
    @BeforeTest
    public void setUpScanner() {
        InputStream inputStream = new ByteArrayInputStream("10".getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void testIntegerCasting() {
        UserCommunication<Integer> integerInput = new IntegerInput();
        assertTrue(integerInput.read() != null);
    }

    @BeforeMethod
    public void setUpScannerString() {
        InputStream inputStream = new ByteArrayInputStream("X".getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void testMarkCasting() {
        UserCommunication<Marks> markInput = new MarksInput();
        assertTrue(markInput.read() != null);
    }

}
