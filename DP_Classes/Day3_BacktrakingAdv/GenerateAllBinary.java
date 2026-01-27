package com.DSA_Training.DP_Classes.Day3_BacktrakingAdv;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinary {
    static List<String> binary(List<String> result, String ans, int n, int index){
        if(index>1 && ans.charAt(index-1)=='1' && ans.charAt(index-2)=='1') return result;
        if(index==n) {result.add(ans); return result;}

        binary(result,ans,n,index+1);
        StringBuilder str = new StringBuilder(ans);
        str.setCharAt(index,'1');
        binary(result,str.toString(),n,index+1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binary(new ArrayList<>(), "000", 3,0));
    }
}
