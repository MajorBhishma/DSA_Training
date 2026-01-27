package com.DSA_Training.DP_Classes.Assignments.Assignment2;

import java.util.Scanner;

public class Que5_LetterTilePossibilities {
    static int find(int[] counts) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            // Use this tile
            counts[i]--;
            sum += 1 + find(counts);
            counts[i]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] counts = new int[26];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String(tiles letters): ");
        for (char c : (sc.next()).toCharArray()) counts[c - 'A']++;
        System.out.println(find(counts));
    }
}
