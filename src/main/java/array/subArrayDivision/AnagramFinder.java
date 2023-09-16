package array.subArrayDivision;

import java.util.*;

public class AnagramFinder {

    public static void main(String[] args) {
        String text = "This text is a test that contains some mose, but not much, punctuation marks! Results are expected since we have also words like chum and era.";
        List<String> anagramWords =AnagramSolution.findAnagramWords(text);
        for (String word : anagramWords) {
            System.out.println(word);
        }
    }


}
class AnagramSolution{
    public static List<String> findAnagramWords(String text) {
        String[] words = text.split("[\\s,.;:!]+");
        Map<String, List<String>> freqMapToWordsMap = new HashMap<>();
        List<String> anagramWords = new ArrayList<>();
        Set<String> added = new HashSet<>();

        // Group words by their character frequencies
        for (String word : words) {
            String freqMap = getFrequencyMap(word.toLowerCase());
            freqMapToWordsMap.putIfAbsent(freqMap, new ArrayList<>());
            freqMapToWordsMap.get(freqMap).add(word);
        }

        // Collect words that have anagrams
        for (String word : words) {
            String freqMap = getFrequencyMap(word.toLowerCase());
            List<String> wordGroup = freqMapToWordsMap.get(freqMap);
            if (wordGroup.size() > 1) {
                for (String anagram : wordGroup) {
                    if (!added.contains(anagram.toLowerCase())) {
                        anagramWords.add(anagram);
                        added.add(anagram.toLowerCase());
                    }
                }
            }
        }

        return anagramWords;
    }

    private static String getFrequencyMap(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        return Arrays.toString(freq);
    }
}