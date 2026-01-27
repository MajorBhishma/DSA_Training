package com.DSA_Training.DP_Classes.Assignments.Assignment6;

import java.util.Arrays;

public class Ques3_TwoFinger_LC1320 {
    int[][][] dp;
    int len;
    public int minimumDistance(String word) {
        len=word.length();
        dp = new int[len][len][len];
        for(int[][] i : dp){
            for(int[] j : i) Arrays.fill(j,-1);
        }
        return solve(word.toCharArray(), 0, -1, -1);
    }

    int solve (char[] words, int index, int lastFinger1, int lastFinger2){
        if(index==len) return 0;
        if(lastFinger1!=-1 && lastFinger2!=-1){
            if(dp[index][lastFinger1+1][lastFinger2+1]!=-1) return dp[index][lastFinger1+1][lastFinger2+1];
        }
        long cost1=lastFinger1==-1 ? 0 : distance(words[index],words[lastFinger1]);
        long cost2=lastFinger2==-1 ? 0 : distance(words[index],words[lastFinger2]);

        cost1 += solve(words,index+1,index,lastFinger2);
        cost2 += solve(words,index+1,lastFinger1,index);

        return dp[index][lastFinger1+1][lastFinger2+1] = (int) Math.min(cost1, cost2);
        // return (int) Math.min(cost1,cost2);
    }

    int distance(char a, char b){
        int row_a = (a - 'A') / 6;
        int column_a = (a-'A') % 6;
        int row_b = (b-'A') / 6;
        int column_b = (b-'A') % 6;
        return ( Math.abs(row_a-row_b) + Math.abs(column_a-column_b) );
    }

    public static void main(String[] args) {
        Ques3_TwoFinger_LC1320 obj = new Ques3_TwoFinger_LC1320();
        System.out.println(obj.minimumDistance("OPVUWZLCKTDPSUKGHAXIDWHLZFKNBDZEWHBSURTVCADUGTSDMCLDBTAGFWDPGXZBVARNTDICHCUJLNFBQOBTDWMGILXPSFWVGYBZVFFKQIDTOVFAPVNSQJULMVIERWAOXCKXBRI"));
    }
}

