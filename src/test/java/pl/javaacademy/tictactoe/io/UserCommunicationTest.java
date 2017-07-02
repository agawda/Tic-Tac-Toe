package pl.javaacademy.tictactoe.io;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.javaacademy.tictactoe.game.Mark;
import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.MarkInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

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
        UserCommunication<Mark> markInput = new MarkInput();
        assertTrue(markInput.read() != null);
    }

}
