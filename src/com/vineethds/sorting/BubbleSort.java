package com.vineethds.sorting;

/**
 * Created by Vineeth on 6/16/2018.
 *  Optimised version of Bubble sort
 *  Worst Case Running Time : O(n^2)
 */
public class BubbleSort {

    public static void main(String[] arg){
        int a[] = {9,8,7,5,3,1};
        BubbleSort bs= new BubbleSort();
        bs.bubble(a);
        bs.printArray(a);
    }

    public void bubble(int a[]){
        boolean swapped =  true;
        while(swapped){
            swapped = false;
            for(int j = 1; j < a.length; j++){
                if(a[j-1] > a[j]){
                    swap(a,j-1,j);
                    swapped = true;
                }
            }

        }
    }

    public void swap(int[] a, int start,int end){

        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start ++;
            end --;
        }
    }

    public void printArray(int a[]){
        for(int i = 0;i < a.length ;i++){
            System.out.print(a[i]+" ");
        }
    }
}
