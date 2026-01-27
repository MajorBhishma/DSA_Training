package com.DSA_Training.DP_Classes.Assignments.Assignment1;

import java.util.Arrays;

//Reverse an Array using recursion
public class Ques9 {
    static void reverseArray(int[] arr, int left, int right) {
        if (left >= right) {System.out.println(Arrays.toString(arr));return;}
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArray(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        reverseArray(arr,0,arr.length-1);
    }
}
