package com.DSA_Training.DP_Classes.Day2_Backtracking;

import java.util.Stack;

public class SortStack {
    static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty())  return;
        int lastElement = stack.pop();
        sortStack(stack);
        insert(stack, lastElement);
    }
    static void insert(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek()>element) {stack.push(element); return;}
        int temp = stack.pop();
        insert(stack,element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(2);
        s1.push(0);
        s1.push(14);
        System.out.println("Input Stack: " + s1);
        sortStack(s1);
        System.out.println("Sorted Stack: " + s1);
    }
}
