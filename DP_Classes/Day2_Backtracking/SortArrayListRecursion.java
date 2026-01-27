package com.DSA_Training.DP_Classes.Day2_Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayListRecursion {
    static void sortArray(ArrayList<Integer> arr){
        if(arr.size()==1) return;
        int lastElement=arr.getLast();
        arr.removeLast();
        sortArray(arr);
        insert(arr,lastElement);
    }
    static void insert(ArrayList<Integer> arr,int element){
        if(arr.size()==0 || element>=arr.getLast()){arr.add(element); return;}
        int temp = arr.getLast();
        arr.removeLast();
        insert(arr,element);
        arr.add(temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of list: ");
        ArrayList<Integer> inputArr = new ArrayList<>();
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.printf("Enter element %d: ",i+1);
            inputArr.add(sc.nextInt());
        }
        ArrayList<Integer> sortedArr = new ArrayList<>(inputArr);
        sortArray(sortedArr);
        System.out.println("Input array: " + inputArr);
        System.out.println("Sorted array: " + sortedArr);
    }
}
