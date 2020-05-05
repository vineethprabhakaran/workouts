package com.vineethds.arrays;

public class MoveZeros {

    public void moveZeros(int[] nums){
        int statingIndex = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i]!=0){
                int t = nums[i];
                nums[i] =  nums[statingIndex];
                nums[statingIndex] = t;
                statingIndex ++;
            }
        }
    }
    public static void main(String[] args) {
        MoveZeros mz  = new MoveZeros();
        int[] arr = {0,1,0,3,12};
        mz.moveZeros(arr);
        for(int a : arr){
            System.out.print(a+" ");
        }
    }
}
