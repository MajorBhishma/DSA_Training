package com.DSA_Training.Graph_Classes.Assignments.Day4;

import java.util.*;

public class MaxAreaOfIslandLC {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)
                    ans=Math.max(ans,BFS(grid, i, j, m, n));
            }
        }
        return ans;
    }

    int BFS(int[][] grid, int sr, int sc, int m, int n){
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        q.offer(sr*n + sc);
        grid[sr][sc]=2;

        while(!q.isEmpty()){
            int cell = q.poll();
            int x = cell/n;
            int y = cell%n;

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1){
                    q.offer(nx*n + ny);
                    grid[nx][ny]=2;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        MaxAreaOfIslandLC obj = new MaxAreaOfIslandLC();
        int ans = obj.maxAreaOfIsland(grid);
        System.out.println(ans);
    }
}
