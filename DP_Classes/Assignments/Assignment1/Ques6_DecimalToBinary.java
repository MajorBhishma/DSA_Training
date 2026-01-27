package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Convert a Decimal Number to Binary using Recursion

public class Ques6_DecimalToBinary {
    static String decToBin(long n){
        if(n==0) return"";
        return(decToBin(n/2)+n%2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        System.out.println(decToBin(sc.nextLong()));
    }
}
