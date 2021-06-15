package com.vineethds.arrays;
/*
Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]
 */
public class SquareSortedArray {
    public static int[] makeSquares(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int highestSquaredNumberIdx = n-1;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int leftnum = arr[left] * arr[left];
            int rightnum = arr[right] * arr[right];
            if(leftnum > rightnum){
                result[highestSquaredNumberIdx--] = leftnum;
                left++;
            }else{
                result[highestSquaredNumberIdx--] = rightnum;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-5,-4,-3,-2,-1};
        int[] res = makeSquares(arr);
        for(int num : res){
            System.out.print(num+" ");
        }

    }
}
