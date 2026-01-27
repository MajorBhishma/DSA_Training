package com.DSA_Training.DP_Classes.Assignments.Assignment5;

import java.util.Arrays;

public class Ques1 {
    static long fact(int n, int x){
        if(n<=x) return 1;

        return n * fact(n-1,x);
    }

    public static void main(String[] args) {
        int n=12, r=5;
        if(r>n) {
            System.out.println(0);
            return;
        }

        long[] dp = new long [n+1];
        Arrays.fill(dp,-1);
        if(n-r>r) r = n-r;
        long numerator = fact(n, r);
        long denominator = fact(n-r, 1);
        numerator /=denominator;
        System.out.println( (int) numerator);
    }

}
