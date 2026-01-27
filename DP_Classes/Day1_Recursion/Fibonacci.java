package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;


public class Fibonacci {
    static int fib(int n){
        if(n==1 || n==2) return n-1;
        return fib(n-1)+fib(n-2);
    }
    static void tailrecurr(int n, int a, int b) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        tailrecurr(n - 1,b, b+a );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println(fib(n));
        tailrecurr(n,0,1);
    }
}
