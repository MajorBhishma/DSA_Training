package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Arrays;

//Merge Two Sorted Lists using recursion

public class Ques10_Merge2SortedList {
    static void merge(int[] arr1, int[] arr2,int[] ans, int ptr1, int ptr2,int ptr3){
        if(ptr1==arr1.length && ptr2==arr2.length) {
            System.out.println("Merged List: " + Arrays.toString(ans));
            return;
        }
        if(ptr1==arr1.length) ans[ptr3++]=arr2[ptr2++];
        else if(ptr2==arr2.length) ans[ptr3++]=arr1[ptr1++];
        else{
            if(arr1[ptr1]<arr2[ptr2]) ans[ptr3++]=arr1[ptr1++];
            else ans[ptr3++]=arr2[ptr2++];
        }
        merge(arr1,arr2,ans,ptr1,ptr2,ptr3);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,4,6,8,9};
        int[] arr2 = new int[] {3,5,6,8,9,10};
        merge(arr1, arr2, new int [arr1.length+arr2.length],0,0,0);
    }
}
