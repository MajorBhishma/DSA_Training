package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    static void hanoi(int n, char source, char destination, char auxilary){
        if(n==1) {System.out.println("Move disk 1 from rod " + source + " to " + destination); return;}
        hanoi(n-1, source, auxilary, destination);
        System.out.println("Move disk " + n + " from rod " + source + " to " + destination);
        hanoi(n-1,auxilary,destination,source);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        hanoi(sc.nextInt(),'A','C','B');
    }
}
