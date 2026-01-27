package com.DSA_Training.DP_Classes.Day2_Backtracking;

import java.util.Stack;

public class ReverseAStack {
    static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int value = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack,value);
    }
    static void insertAtBottom(Stack<Integer> stack, int value){
        if(stack.isEmpty()) {stack.push(value); return;}
        int temp = stack.pop();
        insertAtBottom(stack,value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(10);
        s1.push(6);
        s1.push(1);
        s1.push(7);
        s1.push(3);
        System.out.println("Input stack: " + s1);
        reverseStack(s1);
        System.out.println("Output stack: " + s1);
    }
}
