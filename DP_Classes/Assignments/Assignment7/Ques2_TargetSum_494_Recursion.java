package com.DSA_Training.DP_Classes.Assignments.Assignment7;

import java.util.Arrays;

public class Ques2_TargetSum_494_Recursion {
    int[] nums;
    int target,len;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        len=nums.length;
        return throughRecursion(0,0);

    }
    int throughRecursion(int index, int sum){
        if(sum==target && index==len) return 1;
        if(index>=len) return 0;


        int plus = throughRecursion(index+1,sum+nums[index]);
        int minus = throughRecursion(index+1, sum-nums[index]);

        return plus+minus;
    }

    public static void main(String[] args) {
        Ques2_TargetSum_494_Recursion obj = new Ques2_TargetSum_494_Recursion();
        System.out.println(obj.findTargetSumWays(new int[] {1,1,1,1,1}, 3));
    }
}
