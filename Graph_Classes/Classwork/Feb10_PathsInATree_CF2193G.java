package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;

public class Feb10_PathsInATree_CF2193G {

    static void DFS(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> dfs){
        visited[node] = true;
        dfs.add(node);

        for(int i : adj.get(node)){
            if(!visited[i]){
                DFS(i, visited, adj, dfs);
            }
        }

    }

    static void solve(List<List<Integer>> adj, int n, BufferedReader bf, StringTokenizer st) throws IOException{

        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        DFS(1, visited, adj, dfs);
        int i = 0;
        while(i<n){

            System.out.println("? "+dfs.get(i)+" "+((i+1==n)?dfs.get(i):dfs.get(i+1)));
            System.out.flush();
            st = new StringTokenizer(bf.readLine());
            int output = Integer.parseInt(st.nextToken());

            if(output==1) break;
            i+=2;
        }
        if(i==n-1){
            System.out.println("! " + dfs.get(i));
            return;
        }

        System.out.println("? " + dfs.get(i) + " " + dfs.get(i));
        System.out.flush();
        st = new StringTokenizer(bf.readLine());
        System.out.println(Integer.parseInt(st.nextToken())==1 ? "! " + dfs.get(i) : "! " + dfs.get(i+1));
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<List<Integer>> adj = new ArrayList<>();
            for(int j=0; j<=n; j++){
                adj.add(new ArrayList<>());
            }
            for(int j=0; j<n-1; j++){
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            solve(adj, n, bf, st);
        }
    }
}
