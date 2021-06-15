package com.vineethds.DP;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class SubSetSumSpaceEfficient {

    public boolean canPartition(int[] nums, int sum){
        if(sum == 0)
            return true;

        if(nums.length == 0)
            return  false;

        Boolean[] dp = new Boolean[sum + 1];
        for(int s = 0; s <= sum; s++){
            dp[s] = nums[0] == s;
        }

        for(int i = 1; i < nums.length; i++){
            for(int s = sum; s > 0; s--){
                if(!dp[s] && s >= nums[i]){
                    dp[s] = dp[s - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubSetSumSpaceEfficient ss = new SubSetSumSpaceEfficient();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}
