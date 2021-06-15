package com.vineethds.DP;

public class KnapsackSpaceEfficient {

    private int solveKnapsack(int[] profits, int[] weights, int capacity){
        if(capacity <=0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        for(int c = 0; c <= capacity; c++){
            if(weights[0] <= c)
                dp[c] = profits[0];
        }

        for(int i = 0 ; i < n; i++){
            for(int c = capacity; c >= 0; c--){
                int profit1 = 0 , profit2 = 0;
                if(weights[i] <= c){
                    profit1 = profits[i] + dp[c - weights[i]];
                }
                profit2 = dp[c];
                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        KnapsackSpaceEfficient ks = new KnapsackSpaceEfficient();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
