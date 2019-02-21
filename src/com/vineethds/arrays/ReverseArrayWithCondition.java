package com.vineethds.arrays;

/*
@author Vineeth
Input: -1,-1,6,1,9,3,2,-1,4,-1
Output: -1 1 2 3 4 -1 6 -1 -1 9
Order: O(n)
 */
public class ReverseArrayWithCondition {

    public static void reverseArray(int[] a){
        for(Integer val : a){
            System.out.print(val+" ");
        }
        for(int i = 0; i < a.length;){
            if(a[i] != -1 && a[i] != i){
                swap(a,i);
                continue;
            }
            i++;
        }
        System.out.println("");
        for(Integer val : a){
            System.out.print(val+" ");
        }
    }
    public static void main(String[] args) {
        int[] a = {-1,-1,6,1,9,3,2,-1,4,-1};
        reverseArray(a);

    }
    public static void swap(int[] a , int i){
        int t = a[i];
        a[i] = a[t];
        a[t] = t;
    }
}
