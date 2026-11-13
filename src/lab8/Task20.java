/*Подсчитать количество содержащихся в данном тексте знаков препинания. */
package lab8;

public class Task20 {
    public static void main(String[] args) {
        String text = "67 67 67";
        System.out.println("номер 20");
        System.out.println("Способ 1 (String): " + countPunctuationString(text));
        System.out.println("Способ 2 (Stream API): " + countPunctuationStream(text));
    }

    public static int countPunctuationString(String text) {
        String textWithoutPunct = text.replaceAll("\\p{Punct}", "");
        return text.length() - textWithoutPunct.length();
    }

    public static long countPunctuationStream(String text) {
        return text.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c.toString().matches("\\p{Punct}"))
                .count();
    }
}