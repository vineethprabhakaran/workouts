package com.vineethds.DP;

public class SubsetCountSpaceEfficient {

    public static int countSubsets(int[] nums, int Sum){
        int n = nums.length;
        Integer[] dp = new Integer[Sum + 1];
        dp[0] = 1;
        for(int s = 1; s <= Sum; s++){
            dp[s] = nums[0] == s ? 1 : 0;
        }
        for(int i = 1;i < n; i++){
            for(int s = Sum; s >= 0; s--){
                if(s >= nums[i]){
                    dp[s] = dp[s] + dp[s - nums[i]];
                }

            }
        }
        return dp[Sum];
    }

    public static void main(String[] args) {
        SubsetCountSpaceEfficient ss = new SubsetCountSpaceEfficient();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
