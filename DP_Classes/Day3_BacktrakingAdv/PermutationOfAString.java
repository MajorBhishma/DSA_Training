package com.DSA_Training.DP_Classes.Day3_BacktrakingAdv;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfAString {
    static void recur( String str, int i){
        if(i==str.length()) {System.out.println(str);return;}
//        Set<Character>set1=new HashSet<>();
//        set1.add(str.charAt(i));
        for (int j=i;j<str.length();j++){
//            if(i!=j && set1.contains(str.charAt(j))) continue;
            recur(swapp(str,i,j),i+1);
        }

    }
    static String swapp(String input, int i, int j){
        StringBuilder s = new StringBuilder(input);
        char temp=s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,temp);
        return s.toString();
    }

    public static void main(String[] args) {
        recur("ABC",0);
    }
}
