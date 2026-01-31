package com.DSA_Training.Graph_Classes.Classwork.ExtraPracticeDay3;
import java.util.*;

public class Dijsktra_CF_20C {
    static void dijkstra(int n, List<List<int[]>> adj, int src) {
        boolean[] finalized = new boolean[n+1];
        long[] dist = new long[n+1];
        int[] parent = new int[n+1];

        Arrays.fill(dist,Long.MAX_VALUE);
        dist[src]=0;

        Queue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        q.offer(new long[] {src, 0});

        while(!q.isEmpty()){
            long[] node = q.poll();
            int u = (int)node[0];
            if(finalized[u]) continue;
            finalized[u]=true;

            if(u==n) break;

            for(int[] i : adj.get(u)){
                int v = i[0];
                long d = i[1];

                if(!finalized[v]){

                    long newDist = dist[u]+d;
                    if(newDist<dist[v]){
                        dist[v]=newDist;
                        q.offer(new long[] {v, dist[v]});
                        parent[v]=u;
                    }
                }
            }
        }

        if(parent[n]==0) {
            System.out.print(-1);
            return;
        }

        List<Integer> ans = new ArrayList<>();
        int p = n;
        while(p!=1){
            ans.add(p);
            p=parent[p];
        }
        ans.add(1);

        int s = ans.size();
        for(int i=s-1; i>=0; i--){
            System.out.print(ans.get(i));
            if(i>0) System.out.print(" ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();

            adj.get(u).add(new int[] {v,d});
            adj.get(v).add(new int[] {u,d});
        }
        dijkstra(n, adj, 1);
    }
}