package com.DSA_Training.Graph_Classes.Assignments.Day1;
import java.util.*;

public class NumberOfProvincesLC {
    public int findCircleNum(int[][] isConnected) {
        int ans=0, n=isConnected.length;
        boolean visited[]= new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int j=0; j<n; j++){
                        if(isConnected[node][j]==1 && !visited[j]){
                            q.offer(j);
                            visited[j]=true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfProvincesLC obj = new NumberOfProvincesLC();
        int[][] x= {{1,1,0},{1,1,0},{0,0,1}};
        int ans = obj.findCircleNum(x);
        for(int[] i : x) System.out.println(Arrays.toString(i));
        System.out.println("\nNumber of provinces: "+ans);
    }
}
