package common;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

import java.util.Stack;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty() || stackMin.peek() >= x) {
            stackMin.push(x);
        }
    }

    public void pop() {
        if (stackMin.peek().equals(stackData.peek())) {
            stackMin.pop();
        }
        stackData.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
