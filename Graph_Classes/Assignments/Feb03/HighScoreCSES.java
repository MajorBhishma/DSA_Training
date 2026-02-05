package com.DSA_Training.Graph_Classes.Assignments.Feb03;
import java.util.*;
import java.io.*;

public class HighScoreCSES {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        int[][] edges = new int[m][3];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
        }


        long[] dist = new long[n+1];
        long INF = Long.MIN_VALUE;

        Arrays.fill(dist, INF);
        dist[1]=0;


        for(int i=0; i<n-1; i++){
            for(int[] j : edges){
                int u = j[0];
                int v = j[1];
                long d = j[2];

                if(dist[u]==INF) continue;
                long newDist = dist[u]+d;
                
                if(newDist>dist[v]){
                    dist[v]=newDist;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        for(int[] j : edges){
            int u = j[0];
            int v = j[1];
            long d = j[2];

            if(dist[u]==INF) continue;
            long newDist = dist[u]+d;

            if(newDist>dist[v]){
                if(v==n) {
                    System.out.println(-1);
                    return;
                }
                dist[v]=newDist;
                q.offer(v);
                visited[v]=true;
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i : adj.get(node)){
                if(!visited[i]){
                    if(i==n){
                        System.out.println(-1);
                        return;
                    }

                    q.offer(i);
                    visited[i]=true;
                }
            }


        }

        System.out.println(dist[n]);
    }
}