package com.vineethds.bitmanipulation;

public class FlipInvertImage {
    public static int[][] flipAndInvertImage(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        for(int i = 0 ; i < rowCount;i++){
            swap(arr,i,0,colCount-1);
        }
        return arr;
    }

    public static void swap(int[][] arr, int i, int start, int end){
        while(start < end){
            int t = arr[i][start] ^ 1;
            arr[i][start] = arr[i][end] ^ 1;
            arr[i][end] = t;
            start++;
            end--;
        }
        if(start == end){
            arr[i][start]  = arr[i][start] ^ 1;
        }
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}
