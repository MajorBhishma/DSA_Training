package com.DSA_Training.Graph_Classes.Assignments.Day4;
import java.util.*;

public class BattleshipInABoardLC {

    int countBattleships(char[][] board) {
        int m=board.length, n=board[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='X'){
                    count++;
                    BFS(board, i, j, m, n);
                }
            }
        }
        return count;
    }

    void BFS(char[][] board, int sr, int sc, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        q.offer(new int[]{sr,sc});
        board[sr][sc]='.';

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]=='X'){
                    q.offer(new int[]{nx,ny});
                    board[nx][ny]='.';
                }
            }

        }
    }

    int withoutExtraSpace (char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='X'){
                    int xCount = 0;
                    if(i+1<m && board[i+1][j]=='X') xCount++;
                    if(j+1<n && board[i][j+1]=='X') xCount++;

                    if(xCount==0) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','.','.','X'},
                {'.','.','.','X'},
                {'.','.','.','X'}
        };
        BattleshipInABoardLC obj = new BattleshipInABoardLC();
        System.out.println(obj.withoutExtraSpace(board));
        System.out.println(obj.countBattleships(board));
    }
}

