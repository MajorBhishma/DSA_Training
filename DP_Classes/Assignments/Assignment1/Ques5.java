package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Count the Number of Zeros in a Number using Recursion
public class Ques5 {
    static void zeroCount(long n,int count){
        if(n>-10 && n<10) {System.out.println("Zero Count: " + count);return;}
        zeroCount(n/10, n%10==0?count+1:count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long n=sc.nextLong();
        if(n==0){System.out.println("Zero Count: 1"); return;}
        zeroCount(n,0);
    }
}
