package stack;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = getCharacters(s.toCharArray());
        Stack<Character> tStack = getCharacters(t.toCharArray());

        if (sStack.size() != tStack.size()) {
            return false;
        }

        while (!sStack.isEmpty()) {
            if (!sStack.pop().equals(tStack.pop())) {
                return false;
            }
        }

        return true;
    }

    private static Stack<Character> getCharacters(char[] s_chars) {
        Stack<Character> stack = new Stack();
        for (char ch : s_chars) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        BackspaceCompare bc = new BackspaceCompare();
        System.out.println(bc.backspaceCompare("hd#dp#czsp#####", "hd#dp#czsp######"));
    }
}
