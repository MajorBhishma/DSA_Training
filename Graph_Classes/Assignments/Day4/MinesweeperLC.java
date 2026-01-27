package com.DSA_Training.Graph_Classes.Assignments.Day4;
import java.util.*;

public class MinesweeperLC {
    public char[][] updateBoard(char[][] board, int[] click) {

        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        int m=board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0,0,-1,1,-1,-1,1,1};
        int[] dy = {-1,1,0,0,-1,1,-1,1};

        q.offer(click);
        visited[click[0]][click[1]] = true;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int count=0;
            List<int[]> adj = new ArrayList<>();

            for(int k=0; k<8; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny]){
                    char ch = board[nx][ny];
                    if(ch=='M') count++;
                    else if (ch=='E'){
                        adj.add(new int[] {nx,ny});
                    }
                }
            }

            if(count==0){
                for(int[] i : adj){
                    q.offer(i);
                    visited[i[0]][i[1]] = true;
                }
                board[x][y]='B';
            }
            else{
                board[x][y]=(char)(count+'0');
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}};
        int[] click = {3,0};

        MinesweeperLC obj = new MinesweeperLC();
        char[][] ans = obj.updateBoard(board, click);
        for(char[] i : ans) System.out.println(Arrays.toString(i));
    }
}
