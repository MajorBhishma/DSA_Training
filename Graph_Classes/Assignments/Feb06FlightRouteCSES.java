package com.DSA_Training.Graph_Classes.Assignments;
import java.util.*;
import java.io.*;

public class Feb06FlightRouteCSES {

    private static void solve(List<List<int[]>> adj, int n, int k){
        Queue<long[]> q = new LinkedList<>();
        List<PriorityQueue<Long>> dist = new ArrayList<>();

        for(int i=0; i<=n; i++) dist.add(new PriorityQueue<>((a,b)->Long.compare(b,a)));

        dist.get(1).offer(0L);
        long[] currDist = new long[n+1];

        q.offer(new long[]{1,0});

        while(!q.isEmpty()){
            long[] node = q.poll();
            int u = (int) node[0];

            for(int[] i : adj.get(u)){
                int v = i[0];
                long d = i[1];

                Queue<Long> temp = dist.get(v);
                long newDist = currDist[u]+d;
                if(temp.size()<k || temp.peek()>newDist){
                    q.offer(new long[] {v, newDist});
                    temp.offer(newDist);
                    if(temp.size()>k) temp.poll();
                    currDist[v] = newDist;
                }
            }
        }

        for(Long i : dist.get(n)) System.out.print(i + " ");

    }
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[] {v,w});

        }

        solve(adj, n, k);

    }
}
