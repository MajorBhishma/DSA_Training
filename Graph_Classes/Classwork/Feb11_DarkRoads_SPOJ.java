package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;

public class Feb11_DarkRoads_SPOJ {

    static void Solve(List<List<int[]>> adj, long total, int n, List<Long> ans){
        Queue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        boolean[] finalized = new boolean[n];
        finalized[0]=true;

        for(int[] i : adj.get(0)){
            q.offer(new long[] {i[0], i[1]});
        }

        long removed = 0;
        int count = 1;

        while(!q.isEmpty()){
            long[] node = q.poll();
            int u = (int)node[0];

            if(finalized[u]) continue;
            finalized[u]=true;
            removed+=node[1];
            count++;
            if(count==n){
                ans.add(total-removed);
                return;
            }

            for(int[] i : adj.get(u)){
                int v = i[0];
                long d = i[1];

                if(!finalized[v]){
                    q.offer(new long[]{v, d});
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Long> ans = new ArrayList<>();

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0) break;

            List<List<int[]>> adj = new ArrayList<>();
            for(int i=0; i<n; i++) adj.add(new ArrayList<>());

            long total = 0L;

            for(int i=0; i<m; i++){
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj.get(u).add(new int[] {v,d});
                adj.get(v).add(new int[] {u,d});
                total+=d;
            }

            Solve(adj, total, n, ans);
        }

        for(long i : ans) System.out.println(i);
    }
}
