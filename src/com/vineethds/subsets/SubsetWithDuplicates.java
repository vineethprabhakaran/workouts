package com.vineethds.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of numbers that might contain duplicates, find all of its distinct subsets.

Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]

TC: O(N* 2^N)
SC: O(N* 2^N)
 */
public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int start = 0, end =0;
        for(int i=0;i < nums.length;i++){
            start = 0;
            if(i > 0 && nums[i] == nums[i-1])
                start = end;

            end = subsets.size();
            for(int j = start; j < end; j++){
                List<Integer> newPerm =  new ArrayList<>(subsets.get(j));
                newPerm.add(nums[i]);
                subsets.add(newPerm);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }

}
