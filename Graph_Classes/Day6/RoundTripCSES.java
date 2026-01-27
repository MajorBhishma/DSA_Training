package com.DSA_Training.Graph_Classes.Day6;

import java.io.*;
import java.util.*;

public class RoundTripCSES {

    static void solve(List<List<Integer>> adj, int n){
        int[] parent = new int[n+1];
        Arrays.fill(parent,-1);
        int ans = -1;

        for(int i=0; i<=n; i++){
            if(parent[i]==-1){
                parent[i]=i;
                ans = DFS(adj, i, parent);
                if(ans>0) break;
            }
        }
        int len=2;
        StringBuilder str = new StringBuilder(Integer.toString(ans));
        if(ans>0){
            int i = ans;
            while(parent[i]!=ans){
                str.append(" ").append(parent[i]);
                i=parent[i];
                len++;
            }
        }
        str.append(" ").append(ans);
        if(ans==-1)
            System.out.println("IMPOSSIBLE");
        else {
            System.out.println(len);
            System.out.println(str);
        }
    }

    private static int DFS (List<List<Integer>> adj, int start, int[] parent){

        for(int i : adj.get(start)){
            if(i!=parent[start]) {
                if(parent[i]!=-1){
                    parent[i]=start;
                    return i;
                }

                parent[i] = start;
                int x = DFS(adj, i, parent);
                if(x>0) return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        solve(adj, n);
    }

    // -------- Fast Scanner using BufferedReader --------
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
