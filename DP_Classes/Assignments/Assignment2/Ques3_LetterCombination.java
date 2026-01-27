package com.DSA_Training.DP_Classes.Assignments.Assignment2;

import java.util.*;

public class Ques3_LetterCombination {
    static String[] letter = new String[] {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        recur(digits,result,"",0);
        return result;
    }

    static void recur(String digits, List<String> result, String ans, int index){
        if(index==digits.length()) {result.add(ans);return;}
        pick(digits,result,ans,index,letter[digits.charAt(index)-'2'],0);

    }
    static void pick (String digits,List<String> result,String ans,int index, String options, int i){
        if(i==options.length()) return;
        recur(digits, result, ans+options.charAt(i),index+1);
        pick(digits,result,ans,index,options,i+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number for letter combinations: ");
        System.out.println(letterCombinations(sc.next()));
    }
}
