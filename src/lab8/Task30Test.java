package lab8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task30Test {

    @Test
    void testJustify() {
        String text = "Java это круто";
        int width = 20;

        String expected = "Java    это    круто"; // ровно по 4 пробела

        assertEquals(expected, Task30.justifyString(text, width));
        assertEquals(expected, Task30.justifyStream(text, width));

        assertEquals(20, Task30.justifyString(text, width).length());
    }
}