package com.DSA_Training.Graph_Classes.Classwork.ExtraPracticeDay3;
import java.util.*;

public class GraphWithoutLongDirectedPaths_CF_1144F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][2];
        for(int i=0; i<m; i++) {
            edges[i]= new int[] {sc.nextInt(), sc.nextInt()};
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] colorArr = new int[n+1];
        Arrays.fill(colorArr, -1);

        colorArr[1]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()){
            int node = q.poll();
            int clr = colorArr[node];

            for(int i : adj.get(node)){
                if(colorArr[i]==-1){
                    colorArr[i]=1-clr;
                    q.offer(i);
                }
                else if(colorArr[i]==clr) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            if(colorArr[u]==0 && colorArr[v]==1) System.out.print(1);
            else System.out.print(0);
        }
    }

}
