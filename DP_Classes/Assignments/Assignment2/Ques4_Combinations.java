package com.DSA_Training.DP_Classes.Assignments.Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Ques4_Combinations {
    static void recur(List<List<Integer>> result, List<Integer> ans, int n, int k, int current ){
        if(ans.size()==k) {result.add(new ArrayList<>(ans));return;}
        if(current>n) return;
        ans.add(current);
        recur(result,ans,n,k,current+1);
        ans.remove(ans.size()-1);
        recur(result,ans,n,k,current+1);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        recur(result,ans,4,2,1);
        System.out.println(result);
    }
}

