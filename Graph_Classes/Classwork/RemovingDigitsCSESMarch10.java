package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;

public class RemovingDigitsCSESMarch10 {
    static int[] dp;
    static int solve(int n){
        if(n<10) return 1;
        if(dp[n]!=-1) return dp[n];

        int temp = n;
        int count = Integer.MAX_VALUE;
        while(temp!=0){
            int x = temp%10;
            if(x!=0) {
                count = Math.min(count, 1 + solve(n - x));
            }
            temp/=10;
        }

        return dp[n] = count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(solve(n));
    }
}
