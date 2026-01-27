package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.*;

public class JosephusProblem {
    static int josephus(int n, int k) {
//        int[] arr = new int [n];
        boolean[] bool = new boolean[n];
        for(int i=0;i<n;i++){
            bool[i]=true;
        }
        int count=n,i=0;
        while(count>1){
            int skip=0;
            while(skip<k){
                if(bool[i])skip++;
                i=(i+1)%n;
            }
            i=(i-1+n)%n;
            bool[i]=false;
//            System.out.println(i+1);
//            System.out.println(Arrays.toString(bool));
            count--;
            i=(i+1)%n;
        }

        for(int x=0;x<n;x++){
            if(bool[x]) return x+1;
        }

        return 0;
    }
    static int recurr(int n, int k){
        if(n==1) return 0;
        return (recurr(n-1,k)+k)%n;
    }

    public static void main(String[] args) {
        System.out.println(josephus(5,2));
        System.out.println(recurr(5,2)+1);
    }
}
