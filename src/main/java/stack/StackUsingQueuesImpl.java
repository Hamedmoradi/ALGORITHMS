package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingQueuesImpl {
    private Deque<Integer> stack;

    public StackUsingQueuesImpl() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addLast(x);
    }

    public int pop() {
        return stack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public boolean empty() {
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your StackUsingQueuesImpl object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
