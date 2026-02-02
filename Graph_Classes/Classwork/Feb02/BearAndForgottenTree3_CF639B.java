package com.DSA_Training.Graph_Classes.Classwork.Feb02;

import java.util.*;
import java.io.*;

public class BearAndForgottenTree3_CF639B {
    public static void main(String[] args) throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        if(d>2*h || (d==1 && n>2)) {
            System.out.println(-1);
            return;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        int left = h;
        int node = 1;
        while(left !=0){
            adj.get(node).add(++node);
            left--;
        }

        left = d-h;

        if(left==0){
            while(node<n){
                adj.get(2).add(++node);
            }
        }
        else{
            adj.get(1).add(++node);
            left--;

            while(left!=0) {
                adj.get(node).add(++node);
                left--;
            }

            while(node<n){
                adj.get(1).add(++node);
            }
        }

        for(int u=1; u<=n; u++) {
            for(int v : adj.get(u)) {
                System.out.println(u + " " + v);
            }
        }
    }
}
