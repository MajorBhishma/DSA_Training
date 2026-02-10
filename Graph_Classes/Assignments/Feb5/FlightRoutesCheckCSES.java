//package com.DSA_Training.Graph_Classes.Assignments.Feb5;
import java.util.*;
import java.io.*;

public class FlightRoutesCheckCSES {

    static int BFS(int src, List<List<Integer>> adj, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.offer(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i : adj.get(node)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]) return i;
        }
        return -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<=n; i++) revAdj.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            revAdj.get(v).add(u);
        }

        boolean[] canTravel = new boolean[n+1];

        int a = BFS(1, adj,n);
        if(a!=-1){
            System.out.println("NO");
            System.out.print(1 + " " + a);
            return;
        }

        a = BFS(1, revAdj, n);
        if(a!=-1){
            System.out.println("NO");
            System.out.print(a + " " + 1);
            return;
        }
        System.out.print("YES");
    }

}
