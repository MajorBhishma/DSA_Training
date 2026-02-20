package com.DSA_Training.Graph_Classes.Assignments;
import java.util.*;
import java.io.*;

public class Feb12_InteractiveGraph_2196C1 {
    static BufferedReader bf;
    static StringTokenizer st;

    static void solve(int n) throws IOException{

        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new HashSet<>());

        int k=2;
        int[] prev;
        while(true){
            System.out.println("? " + k);
            System.out.flush();

            st = new StringTokenizer(bf.readLine());
            int q = Integer.parseInt(st.nextToken());
            if(q==2) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
                prev = new int[]{u,v};
                break;
            }
            k++;
        }

        int count = 1;
        while(count!=n){
            int low = k;
            int high = (int)Math.pow(2,n)-1;
            while(low<=high){
                int mid = low + (high-low)/2;

                System.out.println("? " + mid);
                System.out.flush();

                st = new StringTokenizer(bf.readLine());
                int q = Integer.parseInt(st.nextToken());



            }

            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());

            solve(n);
        }

    }
}