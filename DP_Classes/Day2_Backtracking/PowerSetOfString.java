package com.DSA_Training.DP_Classes.Day2_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSetOfString {
//    static void powerSet(String ans, String str, int index){
//        if(index==str.length()) return;
//        pick(str.charAt(index),str,ans,index+1);
//        notPick(str.charAt(index),str,ans,index+1);
//    static void pick(char ch, String str,String ans,int index){
//    if(index==str.length()) {System.out.println(ans);return;}
//    powerSet(ans+ch,str,index+1);
//    powerSet(ans,str,index+1);
//}
//
//    static void notPick(char ch, String str,String ans,int index){
//        if(index==str.length()) {System.out.println(ans);return;}
//        powerSet(ans,str,index);
//    }
//    }
    static void powerSet(String ans, String str, int index){
        if(index==str.length()) {System.out.println(ans);return;}
        powerSet(ans+str.charAt(index),str,index+1);
        powerSet(ans,str,index+1);
    }


    public static void main(String[] args) {
        powerSet("","ABC",0);
    }
}