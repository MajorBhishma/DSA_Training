package com.DSA_Training.Graph_Classes.Assignments.Day1;
import java.util.*;

public class BakeryCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] edges = new int[m][3];
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges[i]= new int[]{u,v,w};
        }
        Set<Integer> storage = new HashSet<>();
        for(int i=0; i<k; i++){
            storage.add(sc.nextInt());
        }
        Set<Integer> cities = new HashSet<>();
        for(int i = 1; i<=n; i++){
            if(!storage.contains(i)) cities.add(i);
        }
        List<Integer> weights = new ArrayList<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if((cities.contains(u)&& storage.contains(v)) || cities.contains(v) && storage.contains(u)){
                weights.add(edge[2]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i : weights){
            ans=Math.min(ans,i);
        }
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }
}
