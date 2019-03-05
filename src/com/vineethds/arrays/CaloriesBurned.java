package com.vineethds.arrays;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CaloriesBurned {
/*
input:
1. First input takes the number of test cases t.
2  Second input specifies the number of days to burn the calories
3. Third input specifies the maximum number of kilometers ran for each day
output:
t lines which indicate the total number of calories burned.

Calories burned  = 2 * kilometers of previous days + kilometer to run today

1
4
10 20 8 7

Explanations:
2 * 0 + 20 = 20
2 * 20 + 10 = 50
2 * 30 + 8 = 68
2 * 38 + 7 = 83

221

Time Complexity : O(n)
 */
        // Complete the minimumBribes function below.
        static void burnedCalories(int days,int[] q) {
            Arrays.sort(q);
            int n = q.length;
            long calories = 0;
            int prev = 0;
            for(int i =  n-1; i >=0; i--){
                calories += 2 * prev + q[i];
                prev = prev + q[i];
            }
            System.out.println(calories);

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] q = new int[n];

                String[] qItems = scanner.nextLine().split(" ");

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qItems[i]);
                    q[i] = qItem;
                }

                burnedCalories(n,q);
            }

            scanner.close();
        }

}
