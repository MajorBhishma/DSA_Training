package com.DSA_Training.DP_Classes.Day6;

import java.util.*;

public class Boredom_CF455A {

    static long[] freqArr, dp;
    static long maxx,minn;

    static long solve (int index){

        if (index > maxx) return 0;
        if(dp[index]!=-1) return dp[index];

        long ans1 = (freqArr[index]*index) + solve(index+2);
        long ans2 = solve(index+1);
        return dp[index] = Math.max(ans1,ans2);
//        return dp[index];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        maxx=0;
        minn=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i]>maxx) maxx=arr[i];
            if(arr[i]<minn) minn=arr[i];
        }

        freqArr = new long[(int)maxx+1];
        dp = new long[(int)maxx+1];
        Arrays.fill(dp,-1);
        for (long i : arr){
            freqArr[(int)i]+=1;
        }

        System.out.println(solve((int)minn));
    }
}
