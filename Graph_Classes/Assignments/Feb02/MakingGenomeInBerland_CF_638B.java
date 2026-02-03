package com.DSA_Training.Graph_Classes.Assignments.Feb02;
import java.util.*;
import java.io.*;

public class MakingGenomeInBerland_CF_638B {

    static String DFS(int[] adj, int node, String ans){
        if(adj[node]==-1) return ans + (char)(node+'a');
//        ans = ans + (char)(node+'a');

        return DFS(adj, adj[node], ans + (char)(node+'a'));
    }


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());

        int[] adj = new int[26];
        Arrays.fill(adj, -1);

        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);

        for(int i=0; i<n; i++) {
            String s = bf.readLine();

            for(int j = 0; j <s.length(); j++){
                int idx1 = s.charAt(j)-'a';
                if(indegree[idx1]==-1) indegree[idx1]=0;
                if(j>0) {
                    if(indegree[idx1]==0) {
                        int idx2 = s.charAt(j - 1) - 'a';
                        adj[idx2] = idx1;
                        indegree[idx1]++;
                    }
                }
            }
        }

        String ans = "";
        for(int i=0; i<26; i++){
            if(indegree[i]==0){
                ans = ans + (DFS(adj, i, ""));
            }
        }

        System.out.println(ans);
    }
}
