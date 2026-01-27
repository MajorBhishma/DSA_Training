package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Check if an Array is Sorted (Strictly Increasing) using Recursion

public class Ques3 {
    static boolean checkSorted(int[] arr, int index){
        if(index== arr.length) return true;
        if(arr[index]<=arr[index-1]) return false;
        return checkSorted(arr,index+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int len = sc.nextInt();
        if(len<1) {System.out.println("Invalid input!");return;}
        if (len==1) {System.out.println("Array of length 1 is always sorted");return;}
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            System.out.print("Enter element "+(i+1)+": ");
            arr[i]=sc.nextInt();
        }
        System.out.println(checkSorted(arr,1)?"Array is sorted":"Array is not sorted");
    }
}
