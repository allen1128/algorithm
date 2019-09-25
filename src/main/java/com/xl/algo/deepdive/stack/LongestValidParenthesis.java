package com.xl.algo.deepdive.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int index = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(index);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(index); //substring is completed, prepared for the next string
                } else {
                    maxans = Math.max(maxans, index - stack.peek());
                }
            }
            index++;
        }
        return maxans;

    }

    public static void main(String[] args) {
        LongestValidParenthesis lvp = new LongestValidParenthesis();
        System.out.println(lvp.longestValidParentheses("()(()))))"));
    }
}
