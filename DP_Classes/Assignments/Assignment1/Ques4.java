package com.DSA_Training.DP_Classes.Assignments.Assignment1;
import java.util.Scanner;
//Check if a String contains only Digits using Recursion

public class Ques4 {
    static boolean checkDigit(String s, int index){
        if(index==s.length()) return true;
        if(!Character.isDigit(s.charAt(index))) return false;
        return checkDigit(s,index+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        System.out.println(checkDigit(sc.next(),0)?"String is 'Digits only'":"String is not 'Digits only'");
    }
}
