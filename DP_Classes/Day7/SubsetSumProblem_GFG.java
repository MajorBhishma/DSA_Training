package com.DSA_Training.DP_Classes.Day7;

import java.util.Arrays;

public class SubsetSumProblem_GFG {
    class Solution {

         static int[][] dp;
         static int len, summ;
         static int[] arr1;

        static Boolean isSubsetSum(int arr[], int sum) {

            len = arr.length;
            dp = new int[len+1][sum+1];
            for(int[] i : dp) Arrays.fill(i,-1);
            arr1=arr;
            summ=sum;
            return solve(0,0);
        }
        static Boolean solve(int index, int currSum){
            if(currSum>summ) return false;
            if(currSum==summ) return true;
            if(index==len) return false;
            if(dp[index][currSum]!=-1) return dp[index][currSum]==1;

            Boolean a1 = solve(index+1,currSum+arr1[index]);
            Boolean a2=solve(index+1,currSum);
            dp[index][currSum]= a1||a2 ? 1 : 0;
            return dp[index][currSum]==1;
        }

        public static void main(String[] args) {

        }
    }
}
