package com.vineethds.arrays;
/*
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

It is guaranteed that there will be an answer.
Ex:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

example 2 :
[2,3,5,7,11], threshold = 11
Output: 3
 */
public class SmallestThreshold {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        int result = smallestDivisor(nums,threshold);
        System.out.println(result);
    }

    private static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = threshold;
        while(left < right){
            int sum = 0;
            int m = (left + right )/ 2;
            for(int num : nums){
                sum = sum + (num + m - 1)/m;
            }
            if(sum > threshold){
                left = m+ 1;
            }else{
                right = m;
            }
        }
        return right;

    }
}
