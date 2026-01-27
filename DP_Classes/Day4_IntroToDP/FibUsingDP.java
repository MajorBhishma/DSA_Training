package com.DSA_Training.DP_Classes.Day4_IntroToDP;

import java.util.Arrays;

public class FibUsingDP {
    static int recur(int n, int[] DP){
        if(n<2) return n;
        if(DP[n]!=-1) return DP[n];

        DP[n] = recur(n-1,DP) + recur (n-2,DP);
        return DP[n];
    }

    public static void main(String[] args) {
        int n=4;
        int[] DP = new int[n+1];
        Arrays.fill(DP, -1);
        System.out.println(recur(n, DP));
    }
}
