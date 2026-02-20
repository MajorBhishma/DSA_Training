//package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;
public class Feb17PlanetsAndKingdomsCSES {

    static Stack<Integer> stack;
    static int[] ans;

    static void dfs(int u, List<List<Integer>> adj, boolean[] visited, boolean x, int count){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(v, adj, visited, x, count);
            }
        }

        if(x) stack.push(u);
        else{
            ans[u] = count;
        }
    }
    public static void main(String[] args) throws IOException {
        stack = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            revAdj.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i, adj, visited, true, 0);
            }
        }

        visited = new boolean[n+1];
        ans = new int[n+1];
        int count=0;

        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                count++;
                dfs(u, revAdj, visited, false, count);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for(int i=1; i<=n; i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.print(sb);
    }
}
