package com.DSA_Training.DP_Classes.Assignments.Assignment7;

import java.util.Arrays;

public class Ques2_throughDP {
    int[][]dp;
    int[] nums;
    int target,len,total=0;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        len=nums.length;
        for(int i : nums) total+=i;
        dp= new int[len+1][2*total +1];
        for(int[] i : dp) Arrays.fill(i,-1);
        return throughDP(0,0);
    }

    int throughDP( int index, int sum){
        if(sum==target && index==len) return 1;
        if(index>=len) return 0;
        if(dp[index][sum+total]!=-1) return dp[index][sum+total];

        int plus = throughDP(index+1,sum+nums[index]);
        int minus = throughDP(index+1, sum-nums[index]);

        return dp[index][sum+total] = plus + minus;
    }

    public static void main(String[] args) {
        Ques2_throughDP obj = new Ques2_throughDP();
        System.out.println(obj.findTargetSumWays(new int[] {1,1,1,1,1}, 3));
    }
}
