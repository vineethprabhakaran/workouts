package com.vineethds.arrays;

import java.util.Arrays;
/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target
number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

TC: O(n^2)
SC: O(N)
 */
public class TripletSearch {

    public static int searchTriplet(int[] arr, int targetSum) {
        int minDifference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0;i < arr.length-2;i++){
            int right = arr.length-1;
            int left = i+1;
            int first = arr[i];

            while(left < right){
                int targetDifference = targetSum - (first + arr[left] + arr[right]);
                if(targetDifference == 0){
                    return targetSum - targetDifference;
                }
                if(Math.abs(targetDifference) < Math.abs(minDifference) ||
                        (Math.abs(targetDifference) == Math.abs(minDifference)) && targetDifference > minDifference){
                    minDifference = targetDifference;
                }
                if(targetDifference > 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return targetSum - minDifference;
    }

    public static void main(String[] args) {
        System.out.println(TripletSearch.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSearch.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSearch.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
