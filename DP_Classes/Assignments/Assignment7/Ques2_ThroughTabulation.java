package com.DSA_Training.DP_Classes.Assignments.Assignment7;

public class Ques2_ThroughTabulation {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i : nums) total+=i;
        int[][] dp = new int[nums.length+1][2*total+1];
        return 0;

    }
}
