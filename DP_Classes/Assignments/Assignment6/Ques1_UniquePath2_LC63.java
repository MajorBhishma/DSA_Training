package com.DSA_Training.DP_Classes.Assignments.Assignment6;

import java.util.Arrays;

public class Ques1_UniquePath2_LC63 {
    static int[][] dp,arr;
    static int m,n;
    static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        dp=new int[m][n];
        for(int[] i : dp) Arrays.fill(i,-1);
        arr=obstacleGrid;

        return find(0,0);
    }

    static int find(int row, int column){
        if(row==m-1 && column==n-1) return 1-arr[m-1][n-1];
        if(row>=m || column>=n) return 0;
        if(arr[row][column]==1) return 0;
        if(dp[row][column]!=-1) return dp[row][column];


        return dp[row][column] = find(row,column+1) + find(row+1, column);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(input));
    }

}
