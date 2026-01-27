package com.DSA_Training.DP_Classes.Assignments.Assignment4;
import java.util.Arrays;

public class MergeSrt {
    static void mrgSort(int[] nums, int low, int high) {
        if (low == high) return;
        int mid = low + ((high - low) / 2);
        mrgSort(nums, low, mid);
        mrgSort(nums, (mid + 1), high);
        merg(nums, low, mid, high);
    }

    static void merg(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int ptrLeft = low, ptrRight = mid + 1, i = 0;
        while (ptrLeft <= mid && ptrRight <= high) {
            if (nums[ptrLeft] < nums[ptrRight]) {
                temp[i++] = nums[ptrLeft++];
            } else {
                temp[i++] = nums[ptrRight++];
            }
        }
        while (ptrLeft <= mid) {
            temp[i++] = nums[ptrLeft++];
        }
        while (ptrRight <= high) {
            temp[i++] = nums[ptrRight++];
        }
        for (int j = low; j <= high; j++) {
            nums[j] = temp[j - low];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{19, 2, 6, 4, 19, 8, 10, 2, 14, 4,};
        mrgSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}

