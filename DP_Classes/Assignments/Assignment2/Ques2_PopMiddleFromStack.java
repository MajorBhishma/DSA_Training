package com.DSA_Training.DP_Classes.Assignments.Assignment2;

import java.util.Stack;

public class Ques2_PopMiddleFromStack {
    static void delete(Stack<Integer> s, int mid, int index){
        if(index==mid) {s.pop(); return;}
        int temp = s.pop();
        delete(s,mid,index+1);
        s.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(9);
        s.push(3);
        s.push(6);
        s.push(2);
        s.push(8);
        s.push(11);
        s.push(4);
        System.out.println("Original stack: " + s);
        delete(s,s.size()/2,0);
        System.out.println("After poping mid: " + s);
        delete(s,s.size()/2,0);
        System.out.println("After again poping mid: " + s);
    }
}
