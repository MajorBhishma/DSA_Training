package com.DSA_Training.Graph_Classes.Classwork.ExtraPracticeDay2;
import java.util.*;
public class FoxAndNames_CF_510C {

    static String solve(String[] arr, int n){
        int[] indegree = new int[26];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<26; i++) adj.add(new ArrayList<>());

        for(int i=1; i<n; i++){
            String w1 = arr[i-1];
            String w2 = arr[i];

            int n1 = w1.length();
            int n2 = w2.length();
            int ptr=0;

            while(ptr<n1 && ptr<n2 && w1.charAt(ptr)==w2.charAt(ptr)){
                ptr++;
            }

            if(ptr==n2 && ptr<n1) return "Impossible";

            if(ptr<n1 && ptr<n2){
                char ch1 = w1.charAt(ptr);
                char ch2 = w2.charAt(ptr);

                adj.get(ch1-'a').add(ch2-'a');
                indegree[ch2-'a']++;
            }
        }

        StringBuilder ans = new StringBuilder();
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<26; i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.append((char)('a' + node));

            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
        }
        return ans.length()==26? ans.toString() : "Impossible";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.next();
        }

        System.out.println(solve(arr, n));
    }
}
