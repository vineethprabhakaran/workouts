package com.vineethds.DP;

public class EqualSubsetSumBruteForce {


    public boolean canPartitionRec(int[] nums, int sum, int currentIndex){
        if(sum == 0)
            return true;

        if(nums.length == 0 || currentIndex >= nums.length)
            return false;

        if(nums[currentIndex] <= sum){
            if(canPartitionRec(nums, sum - nums[currentIndex], currentIndex + 1))
                return true;
        }

        return canPartitionRec(nums, sum, currentIndex + 1);
    }

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum % 2 != 0)
            return false;

        return canPartitionRec(nums, sum/2, 0);
    }

    public static void main(String[] args) {
        EqualSubsetSumBruteForce ps = new EqualSubsetSumBruteForce();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
