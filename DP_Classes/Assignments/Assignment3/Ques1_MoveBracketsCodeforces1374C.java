package com.DSA_Training.DP_Classes.Assignments.Assignment3;

import java.util.Scanner;

public class Ques1_MoveBracketsCodeforces1374C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i = 0; i < t; i++){
            int n= sc.nextInt();
            String s = sc.next();
            int count=0, min=0;
            for(int j = 0; j <n; j++){
                if(s.charAt(j) == '(') count++;
                else count--;
                min= Math.min(count,min);
            }
            System.out.println(-min);
        }
    }
}
