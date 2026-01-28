package com.DSA_Training.Graph_Classes.Classwork.ExtraQuestionsDay1;
import java.util.Arrays;
import java.util.Scanner;

public class FoxAnd2Dots_CF_510B {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static String cycleDetection(int[][] arr, int n, int m){
        int[][] parent = new int[n][m];
        for(int[] i : parent) Arrays.fill(i, -1);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(parent[i][j]==-1){
                    parent[i][j] = -2;
                    if( DFS(arr,i, j, parent, n, m)) return "Yes";
                }
            }
        }
        return "No";
    }

    static boolean DFS(int[][] arr, int x, int y, int[][] parent, int n, int m){

        int p = parent[x][y];
        int px = p/m;
        int py = p%m;

        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==arr[x][y]){
                if(nx*m + ny != px*m + py) {
                    if (parent[nx][ny] != -1) return true;

                    parent[nx][ny] = x*m + y;
                    if( DFS(arr, nx, ny, parent, n, m)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j]=s.charAt(j)-'A';
            }
        }

        System.out.println(cycleDetection(arr, n, m));
    }
}
