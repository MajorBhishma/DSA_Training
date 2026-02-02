package com.DSA_Training.Graph_Classes.Assignments.ExtraPracticeDay3;
import java.io.*;
import java.util.*;

public class TheTagGame_CF813C {

    public static void main(String[] args) throws Exception {

//        InputStreamReader in = new InputStreamReader(System.in);
//        BufferedReader bf = new BufferedReader(in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] distAlice = new int[n+1];
        Arrays.fill(distAlice, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        distAlice[1]=0;

        int d = 0;
        while(!q.isEmpty()){
            int size = q.size();
            d++;

            for(int i=0; i<size; i++) {
                int node = q.poll();

                for (int j : adj.get(node)){
                    if(distAlice[j]==-1){
                        q.offer(j);
                        distAlice[j]=d;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(distAlice));

        boolean[] visited = new boolean[n+1];
        q.offer(x);
        visited[x]=true;
        d=0;
        int ans = -1;

        while(!q.isEmpty()){
            int size = q.size();
            d++;

            for(int i=0; i<size; i++){
                int node = q.poll();
                ans = Math.max(ans, 2 * distAlice[node]);

                for(int j : adj.get(node)){
                    if(!visited[j] && d<distAlice[j]){
                        q.offer(j);
                        visited[j]=true;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(distBob));

//        int bobMax = -1;
//        int index = 0;
//        for(int i=0; i<=n; i++){
//            int l = distBob[i];
//
//            if(l>bobMax){
//                bobMax=l;
//                index=i;
//            }
//        }
//        System.out.println(bobMax + distAlice[index] + (distAlice[index]-bobMax));
//
//        int ans = -1;
//        for(int i=1; i<=n; i++){
//            if(distBob[i]!=-1){
//                ans = Math.max(ans, distBob[i] + distAlice[i] + (distAlice[i]-distBob[i]));
//            }
//        }
        System.out.println(ans);
    }
}
