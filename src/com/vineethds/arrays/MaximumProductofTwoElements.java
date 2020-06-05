package com.vineethds.arrays;
/*
Given the array of integers nums, you will choose two different indices i and j of
that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is,
(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 */
public class MaximumProductofTwoElements {

    public static int findMaxProduct(int[] nums) {
        if(nums.length < 1)
            return -1;
        int greater = 0;
        int smaller = 0;
        for (int num : nums) {
            if (num > greater) {
                smaller = greater;
                greater = num;
            } else if (num > smaller) {
                smaller = num;
            }
        }
        greater--;
        smaller--;
        return greater * smaller;
    }

    public static void main(String[] args) {
        int[] nums= {1,5,4,5};
        int result = findMaxProduct(nums);
        System.out.println(result);
    }
}
