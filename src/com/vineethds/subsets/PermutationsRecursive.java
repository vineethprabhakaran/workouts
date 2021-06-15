package com.vineethds.subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct numbers, find all of its permutations.
Input: [1,3,5]
Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]

TC: O(N*N!)
SC: O(N*N!)
 */
public class PermutationsRecursive {

    public  static List<List<Integer>> findPermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void generatePermutations(int[] nums, int index, List<Integer> currPerm, List<List<Integer>> result){
        if(currPerm.size() == nums.length){
            result.add(currPerm);
        }else{
            for(int i = 0 ; i <= currPerm.size();i++){
                List<Integer> newPrem = new ArrayList<>(currPerm);
                newPrem.add(i,nums[index]);
                generatePermutations(nums,index+1, newPrem, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsRecursive.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
