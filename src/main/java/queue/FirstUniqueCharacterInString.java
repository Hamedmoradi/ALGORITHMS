package queue;

import java.util.*;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
            queue.offer(c);
        }

        while (!queue.isEmpty()) {
            if (count.get(queue.peek()) == 1) {
                return s.indexOf(queue.peek());
            }
            queue.poll();
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString f = new FirstUniqueCharacterInString();
        System.out.println(f.firstUniqChar("cccaabadb"));
    }
}
