package com.vineethds.DP;

public class PartitionSetMemoization {

    public int canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        Integer[][] dp = new Integer[nums.length][sum];
        return canPartitionRec(dp, nums, 0, 0, 0);
    }

    public int canPartitionRec(Integer[][] dp, int[] nums, int currentIndex, int sum1, int sum2){
        if(currentIndex >= nums.length){
            return Math.abs(sum1 - sum2);
        }
        if(dp[currentIndex][sum1] == null){
            int diff1 = canPartitionRec(dp, nums, currentIndex + 1, sum1 + nums[currentIndex], sum2);
            int diff2 = canPartitionRec(dp, nums, currentIndex + 1, sum1, sum2 + nums[currentIndex]);
            dp[currentIndex][sum1] = Math.min(diff1, diff2);
        }
        return dp[currentIndex][sum1];
    }

    public static void main(String[] args) {
        PartitionSetMemoization ps = new PartitionSetMemoization();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
