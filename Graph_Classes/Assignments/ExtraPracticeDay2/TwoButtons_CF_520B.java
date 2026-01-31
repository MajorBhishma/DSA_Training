package com.DSA_Training.Graph_Classes.Assignments.ExtraPracticeDay2;

import java.util.*;

public class TwoButtons_CF_520B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if(m<=n) System.out.println(n-m);

        else{
            int count = 0;
            while(n*2<m) {
                n *= 2;
                count++;
            }

            while(n!=m){
                int red = (n*2)-m;
            }


        }

    }

}
