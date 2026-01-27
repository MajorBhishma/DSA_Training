package com.DSA_Training.DP_Classes.Day2_Backtracking;

import java.util.Arrays;

public class SortArray {
    static void sort(int[] arr,int index){
        if(index==0) return;
        int lastElement=arr[index];
        sort(arr,index-1);
        insert(arr,lastElement,index);
    }
    static void insert(int[] arr, int element,int index){
        if(index==0
                || arr[index]>element) {arr[index]=element ; return;}
        int temp=arr[index];
        insert(arr,element,index-1);
        arr[index]=temp;
    }

    public static void main(String[] args) {
        int[] arr= new int[] {1,4,2,7,2,5};
        sort(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
