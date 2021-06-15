package com.vineethds.heaps;

public class MinHeap {

    private static void buildMinHeap(int[] heapArray, int heapSize) {
        for(int i = (heapSize -1)/2; i >=0 ; i--){
            minHeapify(heapArray,i,heapSize);
        }
    }

    private static void minHeapify(int[] heapArray, int index, int heapSize) {
        int smallest = index;
        while(smallest < (heapSize/2)){
            int left = 2 * index + 1;
            int right = 2* index + 2;
            if(left < heapSize && heapArray[left] < heapArray[index]){
                smallest = left;
            }
            if(right < heapSize && heapArray[right] < heapArray[smallest]){
                smallest = right;
            }
            if(smallest != index){
                int temp = heapArray[smallest];
                heapArray[smallest] = heapArray[index];
                heapArray[index] = temp;
                index = smallest;
            }else{
                break;
            }
        }
    }

    private static void printArray(int[] heapArray) {
        for(int arr : heapArray){
            System.out.print(arr +" ");
        }
    }

    public static void main(String[] args) {
        int[] heapArray = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };
        buildMinHeap(heapArray,heapArray.length);
        printArray(heapArray);
    }

}
