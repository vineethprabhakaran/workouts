package com.vineethds.arrays;

import java.util.Arrays;
/*
    Author: Vineeth
    Input: {1, 0, 1, 0, 1, 0, 1}
    Output: 0 0 0 1 1 1 1
    Order: O(n)
 */
public class SegregateZerosOnes {
/*
    Algorithm Description
    - keep two pointers left and right if the current element is 0 increment left pointer
    - if the current element is 1 decrement the right pointer
    - Or else add array[left] = 0 & array[right] = 1;
 */

    private static void segregateArray(int[] a) {
        if(a == null|| a.length == 0){
            return;
        }
        int left = 0;
        int right = a.length-1;
        while(left < right){
            while (left < right && a[left] == 0){
                left++;
            }
            while(left < right && a[right] == 1){
                right--;
            }
            if(left < right){
                a[left] = 0;
                a[right] = 1;
                left++;
                right--;
            }
        }
    }

    private static void printArray(int[] a) {
        Arrays.stream(a).forEach(i -> {System.out.print(i + " ");} );
    }

    public static void main(String args[]){
        int []a = {1, 0, 1, 0, 1, 0, 1};
        segregateArray(a);
        printArray(a);
    }
}
