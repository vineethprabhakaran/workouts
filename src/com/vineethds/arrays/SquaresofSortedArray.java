package com.vineethds.arrays;
/*
Given an array of integers A sorted in non-decreasing order,
return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

 */
public class SquaresofSortedArray {

    private int[] sortedSquares(int[] a) {
        //Two pointer method
        int i = 0;
        int  j = 0;
        int  k = 0;
        int n  = a.length;
        int[] ans  = new int[n];
        for(int val : a){
            if(val < 0){
                j++;
            }else{
                break;
            }
        }
        if(i != j ){
            i = j;
            j= j-1;
            while(j != -1 && i != n && k < n){
                if(((a[i] * a[i]) < (a[j] * a[j]))){
                    ans[k] = a[i] * a[i];
                    i++;
                }else{
                    ans[k] = a[j] * a[j];
                    j--;
                }
                k++;
            }
        }else{
            j = -1;
        }

        while(j != -1 &&  k < n){
            ans[k] = a[j] * a[j];
            j--;
            k++;
        }

        while(i != n && k < n){
            ans[k] = a[i] * a[i];
            i++;
            k++;
        }
        return ans;
    }
    public static void main(String[] args) {
        SquaresofSortedArray sq = new SquaresofSortedArray();
        int[] A = {-4,-1,0,3,10};
        int[] ans = sq.sortedSquares(A);
        for(int a : ans){
            System.out.print(a+" ");
        }
    }

}
