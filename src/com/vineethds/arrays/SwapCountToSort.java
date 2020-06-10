package com.vineethds.arrays;
/*
You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
You are allowed to swap any two elements.
You need to find the minimum number of swaps required to sort the array in ascending order.
@Input:{7, 1, 3, 2, 4, 5, 6}
@output: 5
TimeComplexity: O(N) where N is the length of the array
SpaceComplexity: O(1)
 */
public class SwapCountToSort {
    public static int swapCount = 0;
    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 2, 4, 5, 6};
        //{4,3,1,2}
        System.out.println(minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {
        int countSwaps = 0;
        int i = 0;
        int n = arr.length;
        while(i < n){
            if(arr[i] != i+1){
                while(arr[i] != i+1){
                    int t = arr[i];
                    arr[i] = arr[t-1];
                    arr[t-1] = t;
                    countSwaps++;
                }
            }
            i++;
        }
        return countSwaps;
    }
}
