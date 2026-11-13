/*Изменить программу из предыдущего примера так, чтобы она осуществляла форматирование
с выравниванием по обоим краям. Для этого добавить дополнительные пробелы между словами.*/
package lab8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task30 {
    public static void main(String[] args) {
        String text = "Java это оooчень крутой язык программирования клянусь";
        int width = 50;
        System.out.println("10 номер из с");
        System.out.println("Способ 1 (String): \n[" + justifyString(text, width) + "]");
        System.out.println("Способ 2 (Stream API): \n[" + justifyStream(text, width) + "]");
    }

    public static String justifyString(String text, int width) {
        String[] words = text.trim().split("\\s+");
        int totalChars = Arrays.stream(words).mapToInt(String::length).sum();
        int totalSpaces = width - totalChars;
        int gaps = words.length - 1;

        int spacesPerGap = gaps > 0 ? totalSpaces / gaps : 0;
        int extraSpaces = gaps > 0 ? totalSpaces % gaps : 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                int spacesToAdd = spacesPerGap + (i < extraSpaces ? 1 : 0);
                sb.append(" ".repeat(spacesToAdd));
            }
        }
        return sb.toString();
    }

    public static String justifyStream(String text, int width) {
        String[] words = text.trim().split("\\s+");
        int totalChars = Arrays.stream(words).mapToInt(String::length).sum();
        int totalSpaces = width - totalChars;
        int gaps = words.length - 1;
        int spacesPerGap = gaps > 0 ? totalSpaces / gaps : 0;
        int extraSpaces = gaps > 0 ? totalSpaces % gaps : 0;

        return IntStream.range(0, words.length)
                .mapToObj(i -> {
                    if (i == words.length - 1) return words[i];
                    int spaces = spacesPerGap + (i < extraSpaces ? 1 : 0);
                    return words[i] + " ".repeat(spaces);
                })
                .collect(Collectors.joining());
    }
}