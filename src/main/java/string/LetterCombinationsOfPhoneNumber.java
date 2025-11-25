package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        String[] map = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        // Start with an empty string to build on
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            char d = digits.charAt(i);
            // guard against unexpected characters
            if (d < '0' || d > '9') {
                continue;
            }
            String letters = map[d - '0'];
            // if mapping is empty (like '0' or '1'), skip or return empty set:
            if (letters.isEmpty()) {
                // According to constraints digits are ['2','9'], but if '0' or '1' appears
                // we return empty result (no valid combinations).
                return new ArrayList<>();
            }

            List<String> next = new ArrayList<>();
            for (String prefix : result) {
                for (int j = 0; j < letters.length(); j++) {
                    next.add(prefix + letters.charAt(j));
                }
            }
            result = next;
        }

        return result;
    }
    private static final String[] PHONE_MAP = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

//    public List<String> letterCombinations(String digits) {
//        List<String> combinations = new ArrayList<>();
//        if (digits.isEmpty()) return combinations;
//        backtrack(0, digits, new StringBuilder(), combinations);
//        return combinations;
//    }
//
//    private void backtrack(int index, String digits, StringBuilder path, List<String> combinations) {
//        if (index == digits.length()) {
//            combinations.add(path.toString());
//            return;
//        }
//
//        String possibleLetters = PHONE_MAP[digits.charAt(index) - '0'];
//        for (char letter : possibleLetters.toCharArray()) {
//            path.append(letter);
//            backtrack(index + 1, digits, path, combinations);
//            path.deleteCharAt(path.length() - 1); // Backtrack
//        }
//    }
    // quick test
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber s = new LetterCombinationsOfPhoneNumber();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations("2"));
        System.out.println(s.letterCombinations(""));   // []
        System.out.println(s.letterCombinations(null)); // []
    }
}