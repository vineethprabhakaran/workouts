package com.vineethds.others;
/*
count of Non repeating digit
ex:
2 10 15
2 * 10 = 20 (0 common in 10 and 20) - invalid
2 * 11 = 22 (no common) - Valid
2 * 12 = 24 (2 common in 12 and 24) - Invalid
2 * 13 = 26 (no common) - Valid
2 * 14 = 28 (no common) - Valid
2 * 15 = 30 (no common) - Valid
o/p:
Count the number the valid sets  = 4
 */
public class NonRepeatingDigit {
    public static void main(String[] args) {
        NonRepeatingDigit nd = new NonRepeatingDigit();
        int cnt = nd.nonRepeatingDigitProductCount(2,10,15);
        System.out.println(cnt);
    }

    private int nonRepeatingDigitProductCount(int x, int y, int z) {
        int count = 0;

        for(long i = y; i <= z ; i++){
            int[] arr = new int[10];
            boolean isInValid = false;
            long mul = x * i;
            long j = i;

            while(j > 0){
                int num = (int)(j % 10);
                arr[num]++;
                j = j /10;
            }
            j = mul;
            while(j > 0){
                int num = (int)(j % 10);
                if(arr[num] != 0){
                    isInValid = true;
                    break;
                }
                j = j /10;
            }
            if(!isInValid){
                count++;
            }
        }
        return count;
    }
}
