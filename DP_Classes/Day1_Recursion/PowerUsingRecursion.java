package com.DSA_Training.DP_Classes.Day1_Recursion;

public class PowerUsingRecursion {
    static int recur(int n, int p){
        if(p==1) return n;
        if(p%2==0){
            return(recur(n,p/2)*recur(n,p/2));
        }
        else return(recur(n,p/2)*recur(n,p/2)*n);
    }

    public static void main(String[] args) {
        System.out.println(recur(2,10));
    }
}
