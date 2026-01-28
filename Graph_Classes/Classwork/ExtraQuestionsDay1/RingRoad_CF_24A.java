package com.DSA_Training.Graph_Classes.Classwork.ExtraQuestionsDay1;
import java.util.*;

public class RingRoad_CF_24A {

    static int DFS(List<List<int[]>> adj, int u, int p, int cost){
        int ans = Integer.MAX_VALUE;

        for(int[] node : adj.get(u)){
            int v = node[0];
            int w = node[1];

            if(v!=p){
                if(v==1) {
                    return cost + w;
                }
                ans=Math.min(ans, DFS(adj, v, u, cost+w));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new int[] {v,0});
            adj.get(v).add(new int[] {u,w});
        }

        System.out.println(DFS(adj, 1, -1, 0));
    }
}
