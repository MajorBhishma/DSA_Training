package com.DSA_Training.Graph_Classes.Assignments.ExtraPracticeDay2;
import java.util.*;

public class CyclicCompounds_CF_977E {

    static boolean DFS(int node, List<List<Integer>> adj, boolean[] visited, int[] connectedTo){
        boolean ans = connectedTo[node] == 2;
        visited[node]=true;

        for(int i : adj.get(node)){
            if(!visited[i]) {
                ans = DFS(i, adj, visited, connectedTo) && ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] connectedTo = new int[n+1];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
            connectedTo[u]++;
            connectedTo[v]++;
        }


        int ans = 0;
        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(DFS(i, adj, visited, connectedTo)) ans++;
            }
        }
        System.out.println(ans);

    }
}
