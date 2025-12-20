package stack;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDuplicatesLetters {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= chars.length - 1; i++) {
            if (!stack.isEmpty() && Objects.equals(stack.peek(), chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }


    public static void main(String[] args) {
        RemoveDuplicatesLetters removeDuplicatesLetters = new RemoveDuplicatesLetters();
        System.out.println(removeDuplicatesLetters.removeDuplicates("azxxzy"));

    }
}
