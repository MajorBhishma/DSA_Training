package com.DSA_Training.Graph_Classes.Classwork.ExtraPracticeDay2;

import java.util.*;

public class Party_CF_115A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n+1];

        for(int i=1; i<=n; i++){
            int v = sc.nextInt();
            if(v==-1) continue;
            adj.get(v).add(i);
            indegree[i]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(indegree[i]==0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count++;

            for(int i=0; i<size; i++){
                int node = q.poll();
                indegree[node]--;

                for(int j : adj.get(node)){
                    indegree[j]--;
                    if(indegree[j]==0) q.offer(j);
                }
            }

        }
        System.out.println(count);

    }
}
