package com.vineethds.arrays;

/*
    Maximum Sum SubArray - Not kadane Algorithm
    Time Complexity: O(n)  where N - Length of the array elements
    Space Complexity: O(1)
 */
public class MaximumSumSubArray {

    public static int findMaximumSum(int[] arr){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
        System.out.println(findMaximumSum(arr));
    }
}