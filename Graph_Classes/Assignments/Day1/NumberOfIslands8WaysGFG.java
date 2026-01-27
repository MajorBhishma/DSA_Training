package com.DSA_Training.Graph_Classes.Assignments.Day1;
import java.util.*;
public class NumberOfIslands8WaysGFG {
    public int countIslands(char[][] grid) {
        // Code here
        int ans=0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='L' && !visited[i][j]){
                    ans++;
                    BFS(i,j,visited,grid);
                }
            }
        }
        return ans;
    }
    void BFS(int i, int j, boolean[][] visited, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {0,0,-1,1,-1,-1,1,1};
        int[] dy = {-1,1,0,0,-1,1,-1,1};
        Queue<int[]> q = new LinkedList<>();
        int[] node = {i,j};
        q.offer(node);
        visited[i][j]=true;
        while(!q.isEmpty()){
            node = q.poll();
            int a = node[0];
            int b = node[1];
            for(int k=0; k<8; k++){
                int nx = a+dx[k];
                int ny = b+dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]=='L' && !visited[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {{'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}};
        NumberOfIslands8WaysGFG obj = new NumberOfIslands8WaysGFG();
        int ans = obj.countIslands(grid);
        for(char[] i : grid){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("\nTotal Islands(8-ways): " + ans);
    }
}
