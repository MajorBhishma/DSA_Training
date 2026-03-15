//package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;

public class Feb20_BugLife {

    static boolean BFS(int start, Boolean[] color, List<List<Integer>> adj){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = true;

        while(!q.isEmpty()){
            int u = q.poll();
            boolean base = color[u];

            for(int v : adj.get(u)){
                Boolean newColor = color[v];
                if(newColor!=null){
                    if(newColor==base) return false;
                }
                else{
                    q.offer(v);
                    color[v] = !base;
                }
            }
        }
        return true;
    }
    static boolean solve(int n, List<List<Integer>> adj){
        Boolean[] color = new Boolean[n+1];

        for(int i=1; i<=n; i++){
            if(color[i]==null){
                if(!BFS(i, color, adj)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());

        for(int i=1; i<=t; i++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<List<Integer>> adj = new ArrayList<>();
            for(int j=0; j<=n; j++) adj.add(new ArrayList<>());

            for(int j=0; j<m; j++){
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            System.out.println("Scenario #" + i + ":");
            if(solve(n, adj)){
                System.out.println("No suspicious bugs found!");
            }
            else System.out.println("Suspicious bugs found!\n");
        }
        System.out.println(sb);
    }
}
