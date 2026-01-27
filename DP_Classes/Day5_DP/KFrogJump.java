package com.DSA_Training.DP_Classes.Day5_DP;

import java.util.Arrays;

public class KFrogJump {
    static int findJumps( int[] nums, int index,int k, int[] dp){
        if (index==0) return 0;
        if(index==1) return Math.abs(nums[1]-nums[0]);
//        if(index<k) return findJumps(Arrays.copyOfRange(nums,0,k+1),k,k-1,dp);

        if(dp[index]!=-1) return dp[index];


        int cost=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(index-i>=0) cost = Math.min(findJumps(nums, index-i, k, dp) + Math.abs(nums[index]-nums[index-i]),cost);
        }

        dp[index]=cost;
        return dp[index];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10, 30, 20, 40, 10, 50};
        int[] nums2 = new int[] {10,40,10,30,50,70,10};
        int[] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        int[] dp2 = new int[nums2.length];
        Arrays.fill(dp2,-1);
        System.out.println(findJumps(nums,nums.length-1,3,dp));
        System.out.println(findJumps(nums2,nums2.length-1,3,dp2));
    }
}
