package com.DSA_Training.DP_Classes.Day6;
//import java.util.Scanner;
//public class DiceRolling_CF1093A {
////    static int[] rolls = new int[] {7,6,5,4,3,2};
////    static int solve(int i, int index){
////        int rem = 1
////    }
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int t = sc.nextInt();
////        int[] input = new int[t];
////        for(int i=0; i<t; i++){
////            input[i] = sc.nextInt();
////        }
////        for(int i:input){
////            solve(i);
////        }
////    }
////}
//
//
//    static int solve(int n){
//        if(n<=1) return 0;
//        return n%7==0 ? n/7 :(n/7) + 1;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for(int i=0; i<t; i++){
//            System.out.println(solve(sc.nextInt()));
//        }
//    }
//}

import java.util.Scanner;
public class DiceRolling_CF1093A {

    static int solve(int n){
        if(n<=1) return 0;
        return n/7 + 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int [t];
        for(int i=0; i<t; i++){
            arr[i]=sc.nextInt();
        }
        for(int i : arr)System.out.println(solve(i));
    }
}
