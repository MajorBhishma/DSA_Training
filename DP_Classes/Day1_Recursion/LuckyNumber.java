package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;
public class LuckyNumber{
    static long lucky(int n) {
        if (n == 1) return 2;
        return (long) Math.pow(2, n) + lucky(n - 1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digit limit: ");
        int n=sc.nextInt();
        System.out.print(lucky(n));
    }
}
