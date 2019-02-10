package com.vineethds.arrays;
/*
    Author: Vineeth
    Input: {1,10,2,8,3,7,4,6,5}
    Output: 5
    Order: O(n^2)
 */
public class LengthofLongestIncreasingSubsequence {
/*
    Algorithm Description
    - problem is solved by DP
    - Create a temp array LIS and keep the first element count as 1(LIS[0]] = 1)
    - For the current element check the numbers which are less than the current element in the left portion
       before the current element in the array
    - Add the count to the temp array in the current element's position
       Formula: LIS[i] = LIS{j]+1 if(LIS{j]+1 > LIS[i])
 */
    private static int getLengthofLongestIncreasingSubsequence(int[] a) {
        if(a == null || a.length == 0){
            return -1;
        }
        int n = a.length;
        int[] Lis  = new int[n];
        int maxlenght = 0;
        Lis[0] = 1;
        for(int i = 1; i<n;i++){
            for(int j = 0; j <= i; j++){
                if(a[i]>a[j] && Lis[i] < Lis[j]+1){
                    Lis[i] = Lis[j]+1;
                }
            }
            if(Lis[i] > maxlenght){
                maxlenght = Lis[i];
            }
        }
        return maxlenght;
    }

    public static void main(String arg[]){
     int a[] = {12, 18, 7, 34, 30, 28, 90, 88};
     int lengthoFLis = getLengthofLongestIncreasingSubsequence(a);
     System.out.print(lengthoFLis);

    }
}
