package com.vineethds.arrays;

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        for(int i = 0; i < n ;i++){
            arr[2 *i ] = nums[i];
            arr[(2 * i)+1] = nums[i+n];
        }
        return arr;
    }
    public static void main(String[] args) {
        ShuffleArray sh = new ShuffleArray();
        int[] nums = {2,5,1,3,4,7};
        int n = nums.length/2;
        int[] res = sh.shuffle(nums,n);
        for(int r : res){
            System.out.print(r +" ");
        }
    }
}
