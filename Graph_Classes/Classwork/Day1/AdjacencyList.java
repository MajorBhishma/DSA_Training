package com.DSA_Training.Graph_Classes.Classwork.Day1;

import java.util.ArrayList;

public class AdjacencyList {
    static void adjList(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);

    }

    public static void main(String[] args) {

        adjList(7, new int[][]{{0,1},{1,2},{1,3},{3,4},{3,5},{5,6},{4,6}});
    }
}
