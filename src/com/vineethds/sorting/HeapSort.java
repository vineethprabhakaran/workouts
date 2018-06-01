package com.vineethds.sorting;

/**
 * Heap Sort Solving Steps:
 * Build Max Heap
 * Sort the Array using Max Heap
 * reference: https://www.ideserve.co.in/learn/heap-sort
 *
 */
public class HeapSort {
    public static void main(String a[]){
        HeapSort hs = new HeapSort();
        int arr[] = {4,3,2,1};
        hs.heapsort(arr);
        hs.printArray(arr);
    }

 public void printArray(int[] arr){
     for (int value:arr) {
         System.out.print(value+" ");
     }
 }

 public void heapsort(int a[]){
        int heapsize = a.length;
        buildmaxHeap(a,heapsize);
        for(int i = a.length-1;i > 0;i--){
            swap(a,0,i);//**
            heapsize--;
            maxify(a,0,heapsize);

        }
 }

 public void buildmaxHeap(int a[],int heapsize){
     int lastelement = a.length -1;//**
     int parentindex = (lastelement-1)/2;
     for(int i= parentindex;i >= 0;i--){
         maxify(a,i,heapsize);
     }
 }

 public void swap(int a[],int start,int end ){
     int temp = a[start];
     a[start] = a[end];
     a[end] = temp;
 }

 public void maxify(int a[],int currIndex,int heapsize){
     int left = 2*currIndex+1; //**
     int right = 2*currIndex +2; //**
     int largest = currIndex;
     if(left < heapsize && a[left] > a[largest]){
         largest = left;
     }
     if(right < heapsize && a[right] > a[largest]){
         largest =  right;
     }
     if(largest != currIndex){
         swap(a,currIndex,largest);
         maxify(a,largest,heapsize);
     }
 }
}
