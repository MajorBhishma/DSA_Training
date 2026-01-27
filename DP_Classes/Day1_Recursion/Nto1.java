package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class Nto1 {
    static void recurr(int n){
        if(n==0) return;
        System.out.println(n);
        recurr(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        recurr(n);
    }
}
