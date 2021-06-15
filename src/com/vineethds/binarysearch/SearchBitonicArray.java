package com.vineethds.binarysearch;
/*
Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is
monotonically increasing and then monotonically decreasing.
Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].

Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.

Input: [1, 3, 8, 4, 3], key=4
Output: 3

TC: O(LogN)
SC: O(1)
 */
public class SearchBitonicArray {

    public static int findMaxIndex(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start != end){
            int mid = start + (end - start)/2;
            if(arr[mid] >  arr[mid +1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static int searchKey(int[] arr, int key, int start, int end){
        while(start <=  end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key)
                return mid;
            if(arr[start] < arr[end]){
                if(key < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }else{
                if(key > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }
        return -1;
    }

    public static int search(int[] arr, int key) {
       int maxIndex = findMaxIndex(arr);
       int keyIndex = searchKey(arr, key, 0, maxIndex);
       if(keyIndex != -1)
           return keyIndex;
        return searchKey(arr, key, maxIndex, arr.length -1);
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}
