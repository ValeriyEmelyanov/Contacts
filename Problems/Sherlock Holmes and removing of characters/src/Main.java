import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String word1 = scanner.nextLine().toLowerCase();
        final String word2 = scanner.nextLine().toLowerCase();
        scanner.close();

        Map<Character, Integer> map1 = getMap(word1);
        Map<Character, Integer> map2 = getMap(word2);

        int sum = 0;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer i = map2.get(entry.getKey());
            if (i == null) {
                sum += entry.getValue();
            } else {
                sum += Math.abs(i - entry.getValue());
            }
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Integer i = map1.get(entry.getKey());
            if (i == null) {
                sum += entry.getValue();
            }
        }

        System.out.println(sum);

    }

    private static Map<Character, Integer> getMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}