package com.vineethds.binarysearch;
/*
Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
You can assume that the array does not have any duplicates.

Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.

TC: O(LogN)
SC: O(1)
 */
public class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr){
        int maxIndex = findMaxIndex(arr);
        if(maxIndex == arr.length -1)
            return 0;
        return maxIndex +1;
    }

    public static  int findMaxIndex(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start != end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= arr[start])
               start = mid +1;
            else
                end = mid -1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
