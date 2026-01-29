package com.DSA_Training.Graph_Classes.Classwork.ExtraPracticeDay2;
import java.util.*;

public class KefaAndPark_CF_580C {

    static int DFS(List<List<Integer>> adj, int node, boolean[] cat, int consecutive, int m, int p){
        if (consecutive > m) return 0;

        if(node!=1 && adj.get(node).size()==1) return 1;

        int count = 0;
        for(int i : adj.get(node)){
            if(i!=p) {
                if (cat[i]) {
                    count += DFS(adj, i, cat, consecutive + 1, m, node);
                } else count += DFS(adj, i, cat, 0, m, node);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] cat = new boolean[n+1];
        for(int i=1; i<=n; i++){
            int x = sc.nextInt();
            if(x==1) cat[i]=true;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(DFS(adj, 1, cat, cat[1]?1:0, m, 1));
    }
}
