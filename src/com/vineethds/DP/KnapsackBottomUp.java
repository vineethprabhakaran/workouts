package com.vineethds.DP;


public class KnapsackBottomUp {

    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        if(capacity <= 0 || profits.length == 0 || profits.length != weights.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        for(int c = 0; c <= capacity; c++){
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for(int i = 1; i< n; i++){
            for(int c = 1; c <= capacity; c++){
                int profit1 = 0, profit2 = 0;
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[i-1][c - weights[i]];

                profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelecteditems(dp, profits, weights, capacity);
        System.out.println("");
        return dp[n -1][capacity];
    }

    public void printSelecteditems(int[][]dp, int[] profits, int[] weights, int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[profits.length - 1][capacity];
        for(int i = profits.length -1; i> 0; i--){
            if(totalProfit != dp[i-1][capacity]){
                System.out.print(" "+weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }
    }


    public static void main(String[] args) {
        KnapsackBottomUp ks = new KnapsackBottomUp();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
