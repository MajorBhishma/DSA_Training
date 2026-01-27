package com.DSA_Training.DP_Classes.Day1_Recursion;

import java.util.Scanner;

public class CheckPalindrome {
    static boolean check(String s, int start, int end ){
        if(start>=end) return true;
        if(s.charAt(start)!=s.charAt(end)) return false;
        check(s,start+1,end-1);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s= sc.next();
        System.out.println(check(s, 0, s.length() - 1) ?"Palindrome":"Not Palindrome");
    }
}
