//package com.DSA_Training.Graph_Classes.Classwork.Feb03;
import  java.util.*;
import java.io.*;

public class CycleFindingCSES {

    private static int DFS(int node, int[] parent, List<List<Integer>> adj, Set<Integer> set){
        for(int i : adj.get(node)){
            if(set.contains(i) && i != parent[node]) {
                if (parent[i]!=0) {
                    parent[i] = node;
                    return i;
                }

                parent[i] = node;
                return DFS(i, parent, adj, set);
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][3];
        long[] dist = new long[n+1];
        int[] parent = new int[n+1];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = d;
            adj.get(u).add(v);
        }

        boolean relaxed = false;

        for(int i=0; i<n-1; i++){
            relaxed = false;
            for(int[] j : edges){
                int u = j[0];
                int v = j[1];
                long d = j[2];

                long newDist = dist[u] + d;
                if(newDist < dist[v]) {
                    relaxed = true;
                    dist[v] = newDist;
                    parent[v]=u;
                }
            }
            if(!relaxed) break;
        }

        int ele = -1;

        for(int[] j : edges){
            int u = j[0];
            int v = j[1];
            long d = j[2];

            long newDist =  dist[u] + d;
            if(newDist<dist[v]){
//                dist[v]=newDist;
                parent[v]=u;
                ele = v;
                break;
            }
        }

        if (ele==-1) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");

        for(int i=0; i<n; i++){
            ele = parent[ele];
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(ele);
        int x = ele;
        while(parent[x]!=ele){
            x=parent[x];
            ans.add(x);
        }
        ans.add(ele);
        for(int i=ans.size()-1; i>=0; i--){
        System.out.print(ans.get(i));
        if(i!=0) System.out.print(" ");

        }
    }
}
