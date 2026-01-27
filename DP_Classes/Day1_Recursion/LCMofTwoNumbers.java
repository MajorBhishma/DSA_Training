package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class LCMofTwoNumbers {
    static void recurr(int a, int b,int ans){
        if(ans%a==0) {System.out.println(ans);return;}
        recurr(a,b,ans+b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int a = sc.nextInt();
        System.out.print("Enter number 2: ");
        int b = sc.nextInt();
        if(b>a){
            recurr(a,b,b);
        }
        else recurr(b,a,a);
    }
}
