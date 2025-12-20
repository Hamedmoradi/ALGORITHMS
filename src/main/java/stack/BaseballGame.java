package stack;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack();
        for (String op : operations) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(String.valueOf(2 * (Integer.parseInt(stack.peek()))));
                    break;
                case "+":
                    int d1 = Integer.parseInt(stack.peek());
                    stack.pop();
                    int d2 = Integer.parseInt(stack.peek());
                    stack.pop();
                    stack.push(String.valueOf(d2));
                    stack.push(String.valueOf(d1));
                    stack.push(String.valueOf(d1 + d2));
                    break;
                default:
                    stack.push(op);
            }
        }
        return stack.stream().mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        System.out.println(game.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
