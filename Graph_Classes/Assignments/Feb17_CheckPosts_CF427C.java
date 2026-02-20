package com.DSA_Training.Graph_Classes.Assignments;
import java.util.*;
import java.io.*;

public class Feb17_CheckPosts_CF427C {
    static void makeStack(int node,List<List<Integer>> adj, Deque<Integer> stack, boolean[] visited){
        visited[node] = true;

        for(int i : adj.get(node)){
            if(!visited[i]){
                makeStack(i, adj, stack, visited);
            }
        }

        stack.push(node);
    }

    static long[] dfs(int node, boolean[] visited, int[] cost, List<List<Integer>> revAdj, long minCost, long ways){
        visited[node] = true;
        long newCost = cost[node];
        if(newCost<minCost) {
            minCost = newCost;
            ways=1;
        }
        else if(newCost==minCost){
            ways++;
        }

        for(int v : revAdj.get(node)){
            if(!visited[v]){
                long[] temp =  dfs(v, visited, cost, revAdj, minCost, ways);
                if(temp[0]<=minCost){
                    minCost = temp[0];
                    ways = temp[1];
                }
            }
        }

        return new long[]{minCost, ways};
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cost = new int[n+1];

        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();

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

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                makeStack(i, adj, stack, visited);
            }
        }

        visited = new boolean[n+1];

        long totalCost = 0;
        long ways = 1;
        while(!stack.isEmpty()){
            int u = stack.poll();
            if(!visited[u]){
//                System.out.println(u);
//                System.out.println(Arrays.toString(visited));

                long[] temp = dfs(u, visited, cost, revAdj, Integer.MAX_VALUE, 0);
//                System.out.println(Arrays.toString(temp));
                totalCost+= temp[0];
                ways = (ways*temp[1]) % 1000000007;
            }
        }
//        System.out.println(Arrays.toString(visited));
        System.out.print(totalCost + " " + ways);
    }
}
