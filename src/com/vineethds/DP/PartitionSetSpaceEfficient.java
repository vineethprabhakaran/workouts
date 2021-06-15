package com.vineethds.DP;

public class PartitionSetSpaceEfficient {
    public int canPartition(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int n = nums.length;
        Boolean[] dp = new Boolean[sum/2 +1];

        for(int s = 0; s <= sum/2; s++){
            dp[s] = nums[0] == s;
        }

        for(int i = 1; i< n;i++){
            for(int s = sum/2; s >= 0; s--){
                if(!dp[s] && s >= nums[i]){
                    dp[s] = dp[s - nums[i]];
                }
            }
        }

        int sum1 = 0;
        for(int s = sum/2; s>= 0; s--){
            if(dp[s]){
                sum1 = s;
                break;
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        PartitionSetSpaceEfficient ps = new PartitionSetSpaceEfficient();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
