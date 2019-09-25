package com.xl.algo;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character exist = stack.peek();
                if (!exist.equals(c)) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates("aabbaccaaa"));
    }
}
