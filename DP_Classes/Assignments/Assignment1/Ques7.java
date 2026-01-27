package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Reverse the Digits of a Number using Recursion

public class Ques7 {
    static void reverse(long n,long rev){
        if(n==0) {System.out.println("Reverse: " + rev);return;}
        reverse(n/10,(rev*10)+n%10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        long n = sc.nextLong();
        if(n<0) {System.out.println("Invalid input");return;}
        if(n<10) {System.out.println("Reverse: " + n); return;}
        reverse(n,0);
    }
}
