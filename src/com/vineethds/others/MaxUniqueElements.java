package com.vineethds.others;

import java.util.*;
/*
Input Format
The first line of input contains two integers  and : representing the total number of integers and the size of the subarray,
respectively. The next line contains  space separated integers.

Output Format
Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input
6 3
5 3 5 2 3 2
Sample Output
3
Explanation
In the sample testcase, there are 4 subarrays of contiguous numbers.

 - Has  unique numbers.
 - Has  unique numbers.
 - Has  unique numbers.
 - Has  unique numbers.
In these subarrays, there are  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .
 */

public class MaxUniqueElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            set.add(num);
            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = (int) deque.removeFirst();
                if (!deque.contains(first)) set.remove(first);
            }

        }
        System.out.println(max);
    }
}
