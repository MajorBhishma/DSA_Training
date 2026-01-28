package com.DSA_Training.Graph_Classes.Assignments.ExtraPracticeDay1;
import java.util.*;

public class IceSkating_CF_217A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] freqX = new int[1001];
        int[] freqY = new int[1001];
        int[][] edges = new int[n][2];
//        int start = -1;
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[i] = new int[] {x,y};
            freqX[x]++;
            freqY[y]++;
//
//            if(!adj.containsKey(y)) {
//                adj.put(y, new ArrayList<>());
//            }
//            adj.get(y).add(x);
//
//            if(start==-1) start = y;
        }

        int count = 0;
        for(int i=0; i<n; i++){
            int x = freqX[edges[i][0]];
            int y = freqY[edges[i][1]];
            if(x!=0 && y!=0) System.out.println( x+ " " + y);
            if(x==1 && y==1) count ++;
        }

//        Set<Integer> set = new HashSet<>();
//        for(int i : adj.get(start)){
//            set.add(i);
//        }

//        for(Map.Entry<Integer, List<Integer>> entry : adj.entrySet()){
//            if(entry.getKey()==start) continue;
//            boolean found = false;
//
//            for(int i : entry.getValue()){
//                if(set.contains(i)) found = true;
//                set.add(i);
//            }

//            if(!found) count++;
//        }

        System.out.println(count);
    }
}
