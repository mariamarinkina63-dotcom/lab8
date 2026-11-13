package lab8;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class Task10Test {

    @Test
    void testTopChars() {
        String text = "ааа бб в"; // 'а' - 3, 'б' - 2, 'в' - 1

        Map<Character, Integer> resultString = Task10.getTopCharsString(text, 2);
        assertEquals(3, resultString.get('а'));
        assertEquals(2, resultString.get('б'));
        assertNull(resultString.get('в')); // 'в' не должна попасть в топ-2

        Map<Character, Long> resultStream = Task10.getTopCharsStream(text, 2);
        assertEquals(3L, resultStream.get('а'));
        assertEquals(2L, resultStream.get('б'));
    }
}