package com.DSA_Training.Graph_Classes.Assignments.Day1;
import java.util.*;
public class NumberOfDistinctIslandsGFG {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<List<Integer>> ans = new HashSet<>();
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    BFS(i,j,visited,grid, ans);
                }
            }
        }
        // System.out.println(ans);
        return ans.size();
    }

    void BFS(int i, int j, boolean[][] visited, int[][] grid, Set<List<Integer>> ans){
        int n=grid.length;
        int m=grid[0].length;
        int maxx = n*m;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> island = new ArrayList<>();
        int base = i*m + j;

        q.offer(base);
        visited[i][j]=true;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!q.isEmpty()){
            int node = q.poll();
            island.add(node-base);
            int a = node/m;
            int b = node%m;
            for(int k=0; k<4; k++){
                int nx = a + dx[k];
                int ny = b + dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1 && !visited[nx][ny]){
                    q.offer(nx*m+ny);
                    visited[nx][ny]=true;
                }
            }
        }
        ans.add(island);
    }

    public static void main(String[] args) {
        NumberOfDistinctIslandsGFG x = new NumberOfDistinctIslandsGFG();
        int[][] arr = new int[][] {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        int ans = x.countDistinctIslands(arr);
        for(int[] i : arr) System.out.println(Arrays.toString(i));
        System.out.println("\nTotal number of Distinct islands: " + ans);
    }
}
