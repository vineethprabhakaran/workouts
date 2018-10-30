package com.vineethds.arrays;

import java.util.Arrays;
import java.util.HashSet;
/*
Problem: LongestConsecutiveSubSequence
Author Vineeth
Input: {1, 9, 3, 10, 4, 20, 2}
output: 1,2,3,4
Order : O(N)
 */
public class LongestConsecutiveSubSequence {

    public static void main(String[] args){
         int[] a = {1, 9, 3, 10, 4, 20, 2};
         findThelongestSubsequence(a);
    }

    private static void findThelongestSubsequence(int[] a) {
        if(a == null || a.length == 0){
            return;
        }
        int n = a.length;
        HashSet<Integer> set = new HashSet<Integer>();


        for (int i=0;i<n;i++){
            set.add(a[i]);
        }
        int startIndex = -1;
        int maxLength = 0;
        for(int i =0; i< n ; i++){
            int j = a[i];
            int count = 0;

            if(!set.contains(a[i]-1)){
                while(set.contains(j)){
                    j++;
                    count++;
                }
            }
            if(count > maxLength){
                maxLength = count;
                startIndex = a[i];
            }
        }
        for(int i = startIndex ; i <= maxLength ;i++){
            System.out.print(i+" ");
        }

    }
}
