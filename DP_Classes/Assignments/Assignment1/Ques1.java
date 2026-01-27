package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Count the Number of Digits in a Number

public class Ques1 {
    static int count(int n,int ans){
        if(n<10 && n>-10)return ans;
        return count(n/10,ans+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        System.out.println("Digit Count: " + count(sc.nextInt(),1));
    }
}
