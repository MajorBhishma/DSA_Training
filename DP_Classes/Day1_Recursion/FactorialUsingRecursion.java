package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class FactorialUsingRecursion {
    static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);

    }
    static void tailrecur(int n, int x){
        if(n==1) {System.out.println(x); return;}
        tailrecur(n-1,x*n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n= sc.nextInt();
        System.out.println(factorial(n));
        tailrecur(n,1);
    }
}
