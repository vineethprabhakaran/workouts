package com.vineethds.DP;

public class PartitionSetBottumUp {

    public int canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][sum/2 +1];
        for(int i = 0 ; i < n; i++){
            dp[i][0] = true;
        }

        for(int s = 0; s <= sum/2; s++){
            dp[0][s] = nums[0] == s;
        }

        for(int i = 1; i< n;i++){
            for(int s = 1; s <= sum/2; s++){
                if(dp[i-1][s]){
                    dp[i][s] = true;
                }else if(s >= nums[i]){
                    dp[i][s] = dp[i -1][s - nums[i]];
                }else{
                    dp[i][s] = false;
                }
            }
        }

        int sum1 = 0;
        for(int s = sum/2; s>= 0; s--){
            if(dp[n-1][s]){
                sum1 = s;
                break;
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        PartitionSetBottumUp ps = new PartitionSetBottumUp();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
