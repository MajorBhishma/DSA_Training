package com.DSA_Training.Graph_Classes.Assignments.Day2_3;
import java.util.*;

public class SurroundedRegionsLC {
    public void solve(char[][] board) {
        int m=board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    BFS(i,j,board, m, n, visited);
                }
            }
        }
    }
    void BFS(int i, int j, char[][]board, int m, int n, boolean[][] visited){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
        List<int[]> region = new ArrayList<>();
        q.offer(new int[] {i,j});
        visited[i][j]=true;
        boolean flag=true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            region.add(node);
            int x=node[0];
            int y=node[1];
            if( flag && (x==0 || x==m-1 || y==0 || y==n-1)) flag=false;
            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]=='O' && !visited[nx][ny]){
                    q.offer(new int[] {nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
        if(flag){
            for(int[] r : region){
                board[r[0]][r[1]] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','O','X'},
                {'X','O','X','X'},
        };

        SurroundedRegionsLC obj = new SurroundedRegionsLC();
        obj.solve(board);

    }
}
