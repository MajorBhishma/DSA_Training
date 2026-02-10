package com.DSA_Training.Graph_Classes.Assignments;
import java.util.*;
import java.io.*;

public class Feb06_FlightRoute_CSES {
    static long INF = Long.MIN_VALUE;
    static int n;

    static void BFS(List<List<Integer>> revAdj, List<Integer> reachable){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        boolean[] visited = new boolean[n+1];
        visited[n]=true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i : revAdj.get(node)){
                if(!visited[i]){

                }
            }
        }
    }

    static void solve(List<List<int[]>> adj, int n, int m, int k){
        Queue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        long[] dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[1] = 1L;

//        q.offer(new long[] {1, });



    }
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][3];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<=n; i++) revAdj.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[] {v,w});
            revAdj.get(v).add(u);

//            edges[i][0] = Integer.parseInt(st.nextToken());
//            edges[i][1] = Integer.parseInt(st.nextToken());
//            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        List<Integer> reachable = new ArrayList<>();
        BFS(revAdj, reachable);

        solve(adj, n, m, k);

    }
}
