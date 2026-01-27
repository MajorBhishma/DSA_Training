package com.DSA_Training.Graph_Classes.Assignments.Day2_3;
import java.util.*;

public class ShortestPathInBinaryMatrixLC {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, ans=1;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1) return 1;
        Queue<int[]> q = new LinkedList<>();
        boolean reached = false;

        q.offer(new int[] {0,0});
        grid[0][0]=1;
        int[] dx = {0,0,-1,1,1,1,-1,-1};
        int[] dy = {-1,1,0,0,1,-1,1,-1};

        while(!q.isEmpty()){
            int s = q.size();
            boolean foundNew = false;
            for(int i=0; i<s; i++){
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];

                for(int k=0; k<8; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]==0){
                        q.offer(new int[] {nx,ny});
                        grid[nx][ny]=1;
                        foundNew = true;
                        if(nx==n-1 && ny==n-1) reached = true;
                    }
                }

            }
            if(!foundNew) return -1;
            else ans++;

            if(reached) return ans;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };

        ShortestPathInBinaryMatrixLC obj = new ShortestPathInBinaryMatrixLC();
        int ans = obj.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
    }
}
