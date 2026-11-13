/* В тексте найти и напечатать n символов (и их количество), встречающихся наиболее часто.
        Решить двумя способами: 1) методы String; 2) Stream API. Обязательно использовать регулярные выражения!*/

package lab8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task10 {
    public static void main(String[] args) {
        String text = "тестовый текст: привет, привет!";
        int n = 3;
        System.out.println("номер 10");

        System.out.println("Способ 1 (String): " + getTopCharsString(text, n));
        System.out.println("Способ 2 (Stream API): " + getTopCharsStream(text, n));
    }

    public static Map<Character, Integer> getTopCharsString(String text, int n) {
        String cleanText = text.replaceAll("[^а-яА-Яa-zA-Z]", "").toLowerCase();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : cleanText.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    public static Map<Character, Long> getTopCharsStream(String text, int n) {
        String cleanText = text.replaceAll("[^а-яА-Яa-zA-Z]", "").toLowerCase();
        return cleanText.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}