package com.DSA_Training.Graph_Classes.Assignments.Day1;
import java.util.*;

public class KeysAndRoomsLC {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i : rooms.get(node)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }

        for(boolean i : visited){
            if(!i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KeysAndRoomsLC obj = new KeysAndRoomsLC();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,3));
        list.add(Arrays.asList(3,0,1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(0));

        boolean ans = obj.canVisitAllRooms(list);
        System.out.println(list);
        System.out.println("\nCan visit all rooms?: "+(ans?"Yes":"no"));
    }
}
