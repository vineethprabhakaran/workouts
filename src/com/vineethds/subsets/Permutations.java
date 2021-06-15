package com.vineethds.subsets;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a set of distinct numbers, find all of its permutations.
Input: [1,3,5]
Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]

TC: O(N*N!)
SC: O(N*N!)
 */
public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for(int num : nums){
            int n = queue.size();
            for(int i = 0 ; i < n; i++){
                List<Integer> oldPrem = queue.poll();
                for(int j = 0; j <= oldPrem.size();j++){
                    List<Integer> newPrem = new ArrayList<>(oldPrem);
                    newPrem.add(j,num);
                    if(newPrem.size() == nums.length){
                        result.add(newPrem);
                    }else{
                        queue.add(newPrem);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
