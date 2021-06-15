package com.vineethds.binarysearch;
/*
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].

Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]

TC: O(LogN)
SC: O(1)
 */
public class NumberRange {

    public static int[] findRange(int[] arr, int key){
        int[] result = new int[]{-1,-1};
        result[0] = search(arr, key, false);
        result[1] = search(arr, key, true);
        return result;
    }

    public static int search(int[] arr, int key, boolean findMaxIndex){
        int keyIndex = -1;
        int start = 0;
        int end = arr.length -1;
        while(start <= end){
            int mid = start + (end - start )/2;
            if(key < arr[mid])
                end = mid -1;
            else if(key > arr[mid])
                start = mid +1;
            else{
                keyIndex = mid;
                if(findMaxIndex)
                    start = mid +1;
                else
                    end = mid -1;
            }
        }
        return keyIndex;
    }

    public static void main(String[] args) {
        int[] result = NumberRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = NumberRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = NumberRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
