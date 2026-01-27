package com.DSA_Training.Graph_Classes.Assignments.Day4;
import java.util.*;

public class IslandPeriMeterLC {
    public int islandPerimeter(int[][] grid) {
        int row=grid.length, col=grid[0].length;
        int i=0, j=0;
        int ans=0;
        boolean found = false;
        for(i=0; i<row; i++){
            for(j=0; j<col; j++){
                if(grid[i][j]==1) {
                    found=true;
                    break;
                }
            }
            if(found) break;
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i,j});
        grid[i][j]=2;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int count=0;

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<row && ny>=0 && ny<col && (grid[nx][ny]==1 || grid[nx][ny]==2)){
                    count++;
                    if(grid[nx][ny]==1){
                        q.offer(new int[] {nx,ny});
                        grid[nx][ny]=2;
                    }
                }
            }
            ans += 4-count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        IslandPeriMeterLC obj = new IslandPeriMeterLC();
        int ans = obj.islandPerimeter(grid);
        System.out.println(ans);
    }
}
