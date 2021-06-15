package com.vineethds.DP;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class EqualSubsetSumMemoization {

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[nums.length][ sum /2 + 1];
        return canPartitionRec(dp, nums, sum/2, 0);
    }

    public boolean canPartitionRec(Boolean[][] dp, int[] nums, int sum, int currentIndex){
        if(sum == 0)
            return true;
        if(nums.length == 0 || currentIndex >= nums.length)
            return false;
        if(dp[currentIndex][sum] == null){
            if(nums[currentIndex] <= sum){
                if(canPartitionRec(dp,nums, sum - nums[currentIndex], currentIndex + 1)){
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            dp[currentIndex][sum] = canPartitionRec(dp, nums, sum, currentIndex +1);
        }
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        EqualSubsetSumMemoization ps = new EqualSubsetSumMemoization();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
