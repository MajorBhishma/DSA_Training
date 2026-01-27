package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class GCDofTwoNumbers {
    static void recurr(int a, int b){
        if(b%a==0) {System.out.println(a);return;}
        recurr(b%a, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int a = sc.nextInt();
        System.out.print("Enter number 2: ");
        int b = sc.nextInt();
        if(b>a){
            recurr(a,b);
        }
        else recurr(b,a);
    }
}
