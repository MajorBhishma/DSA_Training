package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Find the Maximum Element in an Array using Recursion

public class Ques2 {
    static void findMax(int[] arr,int index, int maxx){
        if(index==arr.length) {System.out.println("Largest number is: " + maxx); return;}
        findMax(arr,index+1,Math.max(maxx,arr[index]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int len = sc.nextInt();
        if(len<1) {
            System.out.println("Invalid input!");
            return;
        }
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            System.out.print("Enter element "+(i+1)+": ");
            arr[i]=sc.nextInt();
        }
        findMax(arr,0,arr[0]);
    }
}
