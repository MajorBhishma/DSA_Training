package com.DSA_Training.DP_Classes.Assignments.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ques1_NBitBinary {
    static void find(ArrayList<String> result, String ans, int index, int zeroCount, int oneCount, int n){
        if(zeroCount>oneCount)return;
        if(index==n ) {
            result.add(ans);
            return;
        }

        find(result,ans+'1',index+1, zeroCount, oneCount+1,n);
        find(result,ans+'0',index+1, zeroCount+1,oneCount,n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();
        find(result,"",0,0,0,sc.nextInt());
        System.out.println(result);
    }
}
