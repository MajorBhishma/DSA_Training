package com.DSA_Training.Graph_Classes.Classwork;
import java.util.*;
import java.io.*;

public class Feb11_TheTwoRoutes_CF {

    static int BFS(List<HashSet<Integer>> adj, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        visited[1]=true;
        q.offer(1);
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            time++;

            for(int i=0; i<size; i++){
                int u = q.poll();

                for(int v : adj.get(u)){
                    if(v==n) return time;
                    if(!visited[v]){
                        q.offer(v);
                        visited[v]=true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<HashSet<Integer>> rail = new ArrayList<>();
        List<HashSet<Integer>> road = new ArrayList<>();

        for(int i=0; i<=n; i++){
            rail.add(new HashSet<>());
            road.add(new HashSet<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            rail.get(u).add(v);
            rail.get(v).add(u);
        }

        for(int u=1; u<=n; u++){
            for(int v=1; v<=n; v++){
                if(v==u) continue;
                if(!rail.get(u).contains(v)) road.get(u).add(v);
            }
        }

//        System.out.println(road);

        int time1 = BFS(rail, n);
        int time2 = BFS(road, n);

//        System.out.println(time1);
//        System.out.println(time2);

        if(time1==-1 || time2==-1) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.max(time1, time2));
    }
}