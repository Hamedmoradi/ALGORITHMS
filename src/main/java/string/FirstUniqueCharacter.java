package string;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' && freq[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter f = new FirstUniqueCharacter();
        System.out.println(f.firstUniqChar("love leetcode"));
    }
}
/*
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Find first character with count = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character
    }

    public static void main(String[] args) {
        FirstUniqueCharacter f = new FirstUniqueCharacter();
        System.out.println(f.firstUniqChar("i love leetcode"));  // Output: 0
    }
}
*/

/*
class Solution {
    static { for (int i = 0; i < 200; i++) firstUniqChar(""); }
    public static int firstUniqChar(String s) {
        int ind[] = new int[26];
        Arrays.fill(ind, -1);
        int freq[] = new int[26];

        int n = s.length();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            freq[c-'a']++;
            if(ind[c-'a'] < 0){
                ind[c-'a'] = i;
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 1){
                result = Math.min(result, ind[i]);
            }
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}*/
