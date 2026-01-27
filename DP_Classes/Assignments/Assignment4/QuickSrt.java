package com.DSA_Training.DP_Classes.Assignments.Assignment4;

import java.util.Arrays;

public class QuickSrt {
    static void qckSort(int[] nums, int low, int high){
        if(low<high) {
            int p = partition(nums, low, high);
            qckSort(nums, low, p - 1);
            qckSort(nums, p + 1, high);
        }
    }
    static int partition(int[] nums, int low, int high){
        int i=low;
        int j=high;
        int pivot=nums[low];
        while(i<j){
            while(i<=high && nums[i]<=pivot){
                i++;
            }
            while(j>=low && nums[j]>pivot){
                j--;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[low];
        nums[low]=nums[j];
        nums[j]=temp;
//        System.out.println(j);
        return j;
    }

    public static void main(String[] args) {
        int[] nums= new int[] {2,5,7,1,31,2,7,15,9,12,7};
        qckSort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}

