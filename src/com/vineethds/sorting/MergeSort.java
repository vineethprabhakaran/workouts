package com.vineethds.sorting;

/*
Author: Vineeth
input: {2,1,5,4,3}
Output: {1,2,3,4,5}
Order: O(n^2)
 */
public class MergeSort {
    /*
        Algorithm Insights:
        Divide the array by half the length of the array
        Merge the array and during merging sort the array.
     */

    private void printArray(int[] a) {
        for(int num: a){
            System.out.print(num +" ");
        }
    }

    private void mergeSort(int[] a,int s, int e) {
        if(s < e){
            int mid = (s+e)/2;
            mergeSort(a,s,mid);
            mergeSort(a,mid+1,e);
            merge(a, s, mid, e);
        }
    }

    private void merge(int[] a, int s, int mid, int e) {
        int s1 = mid - s + 1;
        int s2 = e - mid;
        int[] temp1 = new int[s1];
        int[] temp2 = new int[s2];

        for(int i = 0; i < s1; i++){
            temp1[i] = a[s + i];
        }
        for(int i = 0 ;i < s2 ;i++){
            temp2[i] = a[mid+i+1];
        }
        int t1 = 0;
        int t2 = 0;
        int k = s; //***
        while(t1 < s1 && t2 < s2){
            if(temp1[t1] < temp2[t2]){
                a[k] = temp1[t1];
                t1++;
            }else{
                a[k] = temp2[t2];
                t2++;
            }
            k++;
        }

        while(t1 < s1){
            a[k] = temp1[t1];
            k++;
            t1++;
        }

        while(t2 < s2){
            a[k] = temp2[t2];
            k++;
            t2++;
        }
    }

    public static void main(String args[]){
        MergeSort ms = new MergeSort();
        int[] a = {2,1,5,4,3};
        ms.mergeSort(a,0,a.length-1);
        ms.printArray(a);

    }
}

