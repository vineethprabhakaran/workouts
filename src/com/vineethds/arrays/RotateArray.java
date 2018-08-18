package com.vineethds.arrays;


public class RotateArray {

    public static void main(String args[]){
        int a[] = {1,2,3,4,5,6,7};
        int n = 16; // Rotating the array n times
        int len = a.length;
        if(n > len){
            n = n % len;
        }
        rotate(a,n);
        printArray(a);
    }

    private static void printArray(int[] a) {
        for(int num : a){
            System.out.print(num+" ");
        }
    }

    private static void rotate(int[] a, int n) {
        rotate(a,0, n-1);
        rotate(a,n,a.length-1);
        rotate(a,0,a.length-1);
    }

    private static void rotate(int[] a, int s,int e){
        while(s<e){
            swap(a,s,e);
            s++;
            e--;
        }
    }

    private static void swap(int[] a, int s, int e) {
        int temp = a[s];
        a[s] = a[e];
        a[e] = temp;
    }

}
