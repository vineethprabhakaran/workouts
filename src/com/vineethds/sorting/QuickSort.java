package com.vineethds.sorting;

/*
@Author: Vineeth
input: {2,1,5,4,3}
Output: {1,2,3,4,5}
Order: O(n^2)
 */
public class QuickSort {

    /*
    Algorithm Insights:
    - Consider last element in the array as the pivot element
    - Find the pivot element's index by if pivot element is greater than current element then j++ and swap i & j
    - After finding the correct index of the pivot element then preform the same process recursively for the elements before the pivot and
    for elements after the pivot.
     */

    private static void quickSort(int[] a, int s, int e) {
        if(s >= e)
            return ;
        int pivotIndex = Partition(a , s, e);
        quickSort(a , s, pivotIndex - 1);
        quickSort(a , pivotIndex + 1, e);
    }

    private static int Partition(int[] a, int s, int e) {
        int pivot = a[e]; // Considering the last element in the array as the pivot element
        int  j = s-1; //**
        for(int i = s; i < e; i++ ){
            if (a[i] <=  pivot){
                j++;
                swap(a,j,i);
            }
        }
        swap(a, j+1, e);
        return j+1;
    }

    public static void swap(int[] a, int i , int j){
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    private static void printArray(int[] a) {
        for(int num : a){
            System.out.print(num +" ");
        }
    }

    public static void main(String args[]){

        int a[] = {2,1,5,4,3};
        int n = a.length -1;
        quickSort(a, 0, n);
        printArray(a);
    }

}
