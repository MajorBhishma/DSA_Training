package com.DSA_Training.Graph_Classes.Assignments;
import java.util.*;
import java.io.*;
public class Feb17CoinCollectorCSES {
    static List<List<Integer>> adj;
    static List<List<Integer>> revAdj;
    static Deque<Integer> stack = new ArrayDeque<>();

    static void makeStack(int i, boolean[] visited){
        visited[i] = true;

        for(int j : adj.get(i)){
            if(!visited[j]){
                makeStack(j, visited);
            }
        }

        stack.push(i);
    }

    static long dfs(int i, boolean[] visited, int[] coins){
        long sum = coins[i];
        visited[i] = true;

        for(int j : revAdj.get(i)){
            if(!visited[j]){
                sum+=dfs(j, visited, coins);
            }
        }

        return sum;
    }

    static void solve(int[] coins, int n){
        boolean[] visited = new boolean[n+1];
        

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                makeStack(i, visited);
            }
        }

        visited = new boolean[n+1];
        long ans = 0;

        while(!stack.isEmpty()){
            int i = stack.pop();
            if(!visited[i]){
                ans += dfs(i, visited, coins);
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];

        st = new StringTokenizer(bf.readLine());

        for(int i=1; i<=n; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList<>();
        revAdj = new ArrayList<>();

        for(int i=0; i<=n; i++) {
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

        solve(coins, n);

    }

}
