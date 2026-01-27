package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class SumOfDigits {
    static void recurr(int n, int x){
        if(n<10) {System.out.println(x+n);return;}
        recurr(n/10,x+(n%10));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        recurr(n,0);
    }
}
