package com.vineethds.sorting;

public class InsertionSort {
/*
Author: Vineeth
input: {9,8,7,5,3,1}
output: 1 3 5 7 8 9
Order: O(n^2)
 */
    public static void main(String args[]){
        int a[] = {9,8,7,5,3,1};
        InsertionSort ins = new InsertionSort();
        ins.sortArrays(a);
        ins.printArray(a);
    }

    private void sortArrays(int[] a) {
        int n = a.length;
        for(int  i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i-1;
            while (j >= 0 && tmp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = tmp;
        }
    }

    public void printArray(int a[]){
        for(int i = 0;i < a.length ;i++){
            System.out.print(a[i]+" ");
        }
    }

}
