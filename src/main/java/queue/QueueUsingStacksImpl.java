package queue;

import java.util.Stack;

public class QueueUsingStacksImpl {
    private Stack<Integer> stack;

    public QueueUsingStacksImpl() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        stack.addLast(x);
    }

    public int pop() {
        return stack.removeFirst();
    }

    public int peek() {
        return stack.getFirst();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
