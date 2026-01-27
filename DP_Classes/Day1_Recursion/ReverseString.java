package com.DSA_Training.DP_Classes.Day1_Recursion;

public class ReverseString {
    static StringBuilder reverse(String str, int i,StringBuilder s){
        if(i==str.length()) return s;
        reverse(str,i+1,s);
        s.append(str.charAt(i));
        return s;
    }
    static char method2(String s, int i, int len){
        if(i==len-1)return(s.charAt(i));
        System.out.println("" + method2(s,i+1,len));
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcdefg",0,new StringBuilder("")));
    }
}
