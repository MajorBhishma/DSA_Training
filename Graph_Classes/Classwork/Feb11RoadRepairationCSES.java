package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;

public class Feb11RoadRepairationCSES {
    static void MST(List<List<int[]>> adj, int n){
        Queue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        boolean[] finalized = new boolean[n+1];

        for(int[] i : adj.get(1)){
            q.offer(new long[]{i[0], i[1]});
        }
        finalized[1]=true;

        int count = 1;
        long cost = 0;

        while(!q.isEmpty()){
            long[] node = q.poll();
            int u = (int) node[0];

            if(finalized[u]) continue;
            finalized[u]=true;
            count++;
            cost+=node[1];
            if(count==n){
                System.out.println(cost);
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
        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }


        MST(adj, n);
    }
}
