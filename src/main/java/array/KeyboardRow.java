package array;

import java.io.IOException;
import java.util.*;

public class KeyboardRow {

    public static String[] findWords(String[] words) {
        /*
          The row1, row2, and row3 sets represent the characters in each row of the keyboard.
          For each word in the input array, it converts the word to a set of characters wordChars.
          It checks if wordChars is a subset of the rows (row1, row2, or row3). If it is, the word is added to the result list.
          Finally, it converts the result list to an array and returns it.
        */
        Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        List<String> result = new ArrayList<>();

        for (String word : words) {
            Set<Character> wordChars = word.toLowerCase().chars().mapToObj(c -> (char) c).collect(HashSet::new, HashSet::add, HashSet::addAll);
            if (row1.containsAll(wordChars) || row2.containsAll(wordChars) || row3.containsAll(wordChars)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(Arrays.stream(new String[]{Arrays.toString(KeyboardRow.findWords(input.split(" ")))}).toList());
    }
}