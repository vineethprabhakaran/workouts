package com.vineethds.DP;

public class EqualSubsetSumBottumUp {

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0 || nums.length == 0)
            return false;

        if(sum == 0)
            return  true;

        sum = sum /2;
        int n = nums.length;

        Boolean[][] dp = new Boolean[n][sum + 1];

        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }

        for(int s = 0; s <= sum; s++){
            if(nums[0] == s){
                dp[0][s] = true;
            }else{
                dp[0][s] = false;
            }
        }

        for(int i=1; i < n; i++) {
            for(int s=1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= nums[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s-nums[i]];
                }else{
                    dp[i][s] = false;
                }
            }
        }
        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        EqualSubsetSumBottumUp ps = new EqualSubsetSumBottumUp();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
