package com.DSA_Training.Graph_Classes.Assignments.ExtraPracticeDay1;
import java.util.*;

public class IceSkating_CF_217A {

    static void BFS(List<List<Integer>> adj, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i : adj.get(node)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        int[][] edges = new int[n][2];
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[i] = new int[] {x,y};
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(edges[i][0]==edges[j][0] || edges[i][1]==edges[j][1]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];

        int count = -1;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                BFS(adj, visited, i);
            }

        }

        System.out.println(count);
    }
}
