package com.DSA_Training.DP_Classes.Assignments.Assignment3;

import java.util.*;
import java.util.stream.Collectors;

public class Ques4_Permutation2_LC47 {

    static void perm2(List<List<Integer>> result, int[] nums, int index){
        if(index==nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        Set<Integer> used = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);
            perm2(result,swapp(nums,i,index),index+1);
            swapp(nums,index,i);
        }
    }
    static int[] swapp(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return nums;
    }

    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();
        perm2(result, new int[] {1,1,2}, 0);
        System.out.println(result);

    }
}
