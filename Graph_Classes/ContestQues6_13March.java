//package com.DSA_Training.Graph_Classes;
//
//public class ContestQues6_13March {
//}
//
//
//
//import java.util.*;
//        import java.lang.*;
//        import java.io.*;
//
//class Codechef
//{
//    static void BFS(int start, int[] arr, List<List<Integer>> adj){
//        Queue<Integer> q = new ArrayDeque<>();
//
//        q.offer(start);
//        arr[start] = -1;
//
//        while(!q.isEmpty()){
//            int node = q.poll();
//
//            for(int i : adj.get(node)){
//                arr[i]--;
//                if(arr[i]>0){
//                    q.offer(i);
//                }
//            }
//        }
//
//    }
//    static int solve(int[][] posters, int n){
//        List<List<Integer>> adj = new ArrayList<>();
//        int[] overlapsWith = new int[n];
//
//        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
//
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                int xa1 = posters[i][0];
//                int xa2 = posters[i][1];
//                int ya1 = posters[i][2];
//                int ya2 = posters[i][3];
//                int xb1 = posters[j][0];
//                int xb2 = posters[j][1];
//                int yb1 = posters[j][2];
//                int yb2 = posters[j][3];
//
//                if((xb1>=xa1 && xb1<=xa2) || (xb2>=xa1 && xb2<=xa2)){
//                    if((yb1>=ya1 && yb1<=ya2) || (yb2>=ya1 && yb2<=ya2)){
//                        adj.get(i).add(j);
//                        adj.get(j).add(i);
//                        overlapsWith[i]++;
//                        overlapsWith[j]++;
//                    }
//
//                }
//            }
//        }
//
//
//        for(int i=0; i<n; i++){
//            if(overlapsWith[i]>0){
//                BFS(i, overlapsWith, adj);
//            }
//        }
//
//        int count = 0;
//
//        for(int i : overlapsWith){
//            if(i==0) count++;
//        }
//
//        return count;
//    }
//    public static void main (String[] args) throws IOException
//    {
//        // your code goes here
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//
//        int t = Integer.parseInt(st.nextToken());
//
//        for(int tc=0; tc<t; tc++){
//            st = new StringTokenizer(bf.readLine());
//            st = new StringTokenizer(bf.readLine());
//            int n = Integer.parseInt(st.nextToken());
//
//            int[][] posters = new int[n][4];
//
//            for(int i=0; i<n; i++){
//                st = new StringTokenizer(bf.readLine());
//                posters[i][0] = Integer.parseInt(st.nextToken());
//                posters[i][1] = Integer.parseInt(st.nextToken());
//                posters[i][2] = Integer.parseInt(st.nextToken());
//                posters[i][3] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(solve(posters, n));
//
//        }
//    }
//}
//
