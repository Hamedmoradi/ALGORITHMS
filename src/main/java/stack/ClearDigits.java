package stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class ClearDigits {
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        ClearDigits c = new ClearDigits();
        System.out.println(c.clearDigits("leet42ode"));
    }
}
