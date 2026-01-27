package com.DSA_Training.DP_Classes.Assignments.Assignment6;

import java.util.Arrays;

public class Ques2_DungeonGame_LC174 {
    int m,n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        dp = new int[m][n];
        for(int[] i : dp) Arrays.fill(i,-1);
        int ans = solve(dungeon, 0, 0);
        return ans;
    }

    int solve(int[][] dungeon, int row, int column){
        if(row==m-1 && column==n-1) {
            if (dungeon[row][column]>=0) return 1;
            else return 1-dungeon[row][column];
        }
        if(dp[row][column]!=-1) return dp[row][column];


        int ans1 = Integer.MAX_VALUE, ans2 = ans1;
        if(column+1<n) ans1 = solve(dungeon, row, column+1) - dungeon[row][column];
        if(row+1<m) ans2 = solve(dungeon, row+1, column) - dungeon[row][column];
        if(ans1<=0) ans1 = 1;
        if(ans2<=0) ans2 = 1;
        dp[row][column] = Math.min(ans1,ans2);
        return dp[row][column];
    }

    public static void main(String[] args) {
        Ques2_DungeonGame_LC174 obj = new Ques2_DungeonGame_LC174();

        int[][] arr = new int[][] {{-2, -3, 3},{-5,-10,1},{10,30,-5}};
        System.out.println(obj.calculateMinimumHP(arr));
    }
}