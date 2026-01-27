package com.DSA_Training.DP_Classes.Day3_BacktrakingAdv;

public class Maze {
    static int ans=0;
    static void findRoute(int[][] maze,int row, int column){
        if(row==maze.length || column==maze[0].length) return;
        if(maze[row][column]==1)return;
        if(row==maze.length-1 && column==maze[0].length-1) {ans=1;return;}
        findRoute(maze,row,column+1);
        findRoute(maze,row+1,column);
    }

    public static void main(String[] args) {
        findRoute(new int[][] {{0,0,0,1},{1,1,0,0},{0,0,1,0},{0,0,0,0}},0,0);
        System.out.println(ans==1?"Possible":"not possible");
    }
}
