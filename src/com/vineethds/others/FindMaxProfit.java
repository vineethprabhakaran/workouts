package com.vineethds.others;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxProfit {



    public static int findMaxprofit(int[] prices) {

       /* int minprice = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length;i++){
            minprice = Math.min(prices[i], minprice);
            maxProfit = Math.max(maxProfit, prices[i] - minprice);
        }
        return maxProfit;*/

        int minimum = prices[0];
        int maximum = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minimum = Math.min(minimum, prices[i]);
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
            maximum = Math.max(maximum, Math.max(maxProfit, prices[i] - minimum));
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] ipprices = {7,6,4,3,1};
        System.out.println(findMaxprofit(ipprices));
    }
}
