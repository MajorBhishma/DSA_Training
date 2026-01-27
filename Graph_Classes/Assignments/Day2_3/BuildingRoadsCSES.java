package com.DSA_Training.Graph_Classes.Assignments.Day2_3;
import java.util.*;
public class BuildingRoadsCSES {
    void solve(int n, List<List<Integer>> adjList){
        List<Integer> componentsHead = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                componentsHead.add(i);
                bfs(n, adjList, i, visited);
            }
        }
        System.out.println(componentsHead.size()-1);
        for(int i = 1; i< componentsHead.size(); i++){
            System.out.println(componentsHead.get(i-1) + " " + componentsHead.get(i));
        }
    }
    void bfs(int n, List<List<Integer>> adjList, int start, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int j : adjList.get(node)){
                if(!visited[j]){
                    q.offer(j);
                    visited[j]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        int u;
        int v;
        for(int i=0; i<m; i++){
            u=sc.nextInt();
            v=sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        BuildingRoadsCSES obj = new BuildingRoadsCSES();
        obj.solve(n,adjList);
    }
}
