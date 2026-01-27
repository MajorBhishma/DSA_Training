package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class OnetoN {
    static void recurr(int n){
        if(n==0) return;
        recurr(n-1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        recurr(n);
    }
}
