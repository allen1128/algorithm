package com.xl.algo;

import java.util.Stack;

public class MinStack {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.size() == 0 || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        Integer x = stack.pop();
        if (min.peek().equals(x)) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());  // Returns -3.
        minStack.pop();
        System.out.println(minStack.getMin());   //Returns -2.
        minStack.pop();
        System.out.println(minStack.getMin());   //Returns -2.
    }
}
