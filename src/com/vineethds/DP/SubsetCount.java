package com.vineethds.DP;

public class SubsetCount {
    static int countSubsets(int[] num, int sum) {

        return countSubsetsRec(num, sum, 0);
    }

    static int countSubsetsRec(int[] num, int sum, int currentIndex){
        if(sum == 0){
            return 1;
        }
        if(currentIndex >= num.length)
            return 0;


        int count1 = 0;
        if(num[currentIndex] <= sum){
            count1 = countSubsetsRec(num, sum - num[currentIndex], currentIndex + 1);
        }
        int count2 = countSubsetsRec(num, sum, currentIndex + 1);

        return count1 + count2;
    }

    public static void main(String[] args) {
        SubsetCount ss = new SubsetCount();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
