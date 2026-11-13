package lab8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task20Test {

    @Test
    void testCountPunctuation() {
        assertEquals(0, Task20.countPunctuationString("67 67 67"));


        String textWithPunct = "Привет, мир! Как дела?";
        assertEquals(3, Task20.countPunctuationString(textWithPunct));
        assertEquals(3L, Task20.countPunctuationStream(textWithPunct));
    }
}