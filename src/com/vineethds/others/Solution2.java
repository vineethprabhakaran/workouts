package com.vineethds.others;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static int fountainActivation(List<Integer> locations) {

        // dp[i]: Stores the position of
        // rightmost fountain that can
        // be covered by water of leftmost
        // fountain of the i-th fountain
        int N = locations.size();
        int[] dp = new int[N];
        for(int i=0;i<N;i++)
        {
            dp[i]=-1;
        }

        // Stores index of leftmost fountain
        // in the range of i-th fountain
        int idxLeft;

        // Stores index of rightmost fountain
        // in the range of i-th fountain
        int idxRight;

        // Traverse the array
        for (int i = 0; i < N; i++)
        {
            idxLeft = Math.max(i - locations.get(i), 0);
            idxRight = Math.min(i + (locations.get(i) + 1), N);
            dp[idxLeft] = Math.max(dp[idxLeft],
                    idxRight);
        }

        // Stores count of fountains
        // needed to be activated
        int cntfount = 1;

        // Stores index of next fountain
        // that needed to be activated
        int idxNext = 0;
        idxRight = dp[0];

        // Traverse dp[] array
        for (int i = 0; i < N; i++)
        {
            idxNext = Math.max(idxNext, dp[i]);

            // If left most fountain
            // cover all its range
            if (i == idxRight)
            {
                cntfount++;
                idxRight = idxNext;
            }
        }
        return cntfount;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1};
        int s = Solution2.fountainActivation(Arrays.asList(1,1,1));
        System.out.print(s);
    }
}

