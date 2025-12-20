package stack;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // if stack is NOT empty, it's NOT outermost
                if (!stack.isEmpty()) {
                    result.append(c);
                }
                stack.push(c);
            } else { // ')'
                stack.pop();
                // if stack is NOT empty after pop, it's NOT outermost
                if (!stack.isEmpty()) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

//    public String removeOuterParentheses(String s) {
//        StringBuilder result = new StringBuilder();
//        int depth = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                if (depth > 0) {
//                    result.append(c);
//                }
//                depth++;
//            } else { // ')'
//                depth--;
//                if (depth > 0) {
//                    result.append(c);
//                }
//            }
//        }
//        return result.toString();
//    }

    public static void main(String[] args) {
        RemoveOutermostParentheses obj = new RemoveOutermostParentheses();
        System.out.println(obj.removeOuterParentheses("(()())(())"));
    }
}
