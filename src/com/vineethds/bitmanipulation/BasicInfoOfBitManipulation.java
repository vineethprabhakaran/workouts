package com.vineethds.bitmanipulation;

public class BasicInfoOfBitManipulation {
    /*
     1. Multiplication by power of 2 (Left shift)
        num << k = num*pow(2,k);
     */
    private static void multiplicationByPowerOfTwo(){
        int num = 5;
        int x = num << 2;
        System.out.println("Multiplication by power of 2: "+ x);
    }

    /*
    2. Division by power of 2 (Right shift)
       num >> k = num/pow(2,k);
     */
    private static void divisionByPowerOfTwo(){
        int num = 5;
        int x = num >> 2;
        System.out.println("Division by power of 2: "+ x);
    }

    /*
    3. To check if an number is odd or even
        if((x & 1) == 0)
            even
        else
            odd
     */
    private static void checkOddOrEven(){
        int num = 5;
        if((num & 1) == 0){
            System.out.println("Check if a number is odd or even: Even");
        }else{
            System.out.println("Check if a number is odd or even: odd");
        }
    }

    /*
    4. Swap two numbers
        x = x ^ y
        y = x ^ y
        x = x ^ y
     */
    private static void swapTwoNumbers(){
        int x = 10;
        int y = 20;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("Swap two numbers x = "+ x +" "+"y = "+y);
    }

    /*
    5. To check if the ith bit is set or not of a number
        x = num & (1 << (i - 1))
        if(x)
            set
        else
            not set
     */
    private static void checkIfIthBitSetOrNot(){
        int num = 5;
        int i = 3;
        int x = num & (1 << (i -1));
        if(x != 0){
            System.out.println("To check if the ith bit is set or not: Set");
        }else{
            System.out.println("To check if the ith bit is set or not: Not set");
        }
    }

    /*
    6. To flip the ith bit of a number
        x = num ^ (1 << (i-1))
     */
    private static void flipIthBit(){
        int num = 5;
        int i = 1;
        int x = num & (i << (i-1));
        System.out.println("To flip ith bit of a number: "+x);
    }

    /*
    7. To turn on ith bit of a number
        x = num | (1 << (i -1))
     */
    private static void turnOnIthBit(){
        int num = 5;
        int i = 2;
        int x = num | (i << (i-1));
        System.out.println("To turn on ith bit of a number: "+x);
    }

    /*
    8. To turn off ith bit of a number
        x = num & ~(1 << (i -1))
     */
    private static void turnOffIthBit(){
        int num = 5;
        int i = 1;
        int x = num & ~(i << (i-1));
        System.out.println("To turn on ith bit of a number: "+x);
    }

    /*
    9. To check if a number is a power of two or not
        x = num & (num - 1)
        if(x == 0)
            power of 2
        else
            not a power of 2

        8 - 1000
        7 - 0111
     */
    private static void checkPowerOf2(){
        int num = 16;
        int x = num & (num -1);
        if(x == 0)
            System.out.println("To check if a number is a power of 2 or not: Power of 2");
        else
            System.out.println("To check if a number is a power of 2 or not:Not a power of 2");
    }

    /*
    10. To convert upper to lower case
        ch = ch | ' '
        ascii value of ' ' id 32
        To convert upper case letter A = 65 to lower case we need to add 32 so 65 + 32 = 97 = a
     */
    private static void convertUpperToLower(){
        char ch = 'A';
        ch = (char) (ch | ' ');
        System.out.println("Convert UpperCase to LowerCase: "+ch);
    }

    /*
    11. To convert lower to upper case
        ch = ch & '_ '
        we need to remove the 5th bit to convert lower case to upper case a - 1100001 A - 1000001
     */
    private static void convertLowertoUpper(){
        char ch = 'a';
        ch = (char) (ch & '_');
        System.out.println("Convert LowerCase to UpperCase: "+ch);
    }

    /*
    12. To find the maximum and minimum of two numbers
        minimum = y ^ ((x ^ y) & -(x < y))
        maximum = x ^ ((x ^ y) & -(x < y))
     */
    private static void findMaxAndMin(){
        int x = 5;
        int y = 10;
        int z = x < y? 1 : 0;
        int min = y ^ ((x ^ y) & -z);
        int max = x ^ ((x ^ y) & -z);
        System.out.println("To find max and min  Max = "+max +" Min = "+min);
    }

    /*
    13. To count the set bits of a number
        int count = 0;
        while(num){
            num = num & (num - 1);
            count++;
        }
        return count;

        When we subtract 1 from a decimal number all the bits after the rightmost set bit will be flipped including the rightmost bit
        5 = 101
        4 = 100

        7 - 111
        6 - 110
     */
    private static void countSetBits(){
        int num = 5;
        int count = 0;
        while(num != 0){
            num = num & (num -1);
            count++;
        }
        System.out.println("To count the set bits of a number: "+ count);
    }

    /*
    14. To count the leading zeros
     */
    private static void countLeadingZeros(){
        int num = 5;
        int res = 0;
        int y = 0;
        int n = 32;

        y = num >> 16;
        if(y != 0 ){
            n = n - 16;
            num = y;
        }
        y = num >> 8;
        if(y != 0 ){
            n = n - 8;
            num = y;
        }
        y = num >> 4;
        if(y != 0 ){
            n = n - 4;
            num = y;
        }
        y = num >> 2;
        if(y != 0 ){
            n = n - 2;
            num = y;
        }
        y = num >> 1;
        if(y != 0 ){
            res = n - 2;
        }else{
           res = n - num;
        }

        System.out.println("To count the Leading zeros: "+ res);
    }

    /*
    15. To count trailing zeros
        int count = 0;
        while((num & 1) == 0){
            num = num >> 1;
            count++;
        }
        return count;
     */
    private static void countTrailingZeros(){
        int num = 8;
        int count = 0;
        while((num & 1) == 0){
            num = num >> 1;
            count++;
        }
        System.out.println("To count the trailing zeros: "+ count);
    }

    public static void main(String[] args) {
        BasicInfoOfBitManipulation.multiplicationByPowerOfTwo();
        BasicInfoOfBitManipulation.divisionByPowerOfTwo();
        BasicInfoOfBitManipulation.checkOddOrEven();
        BasicInfoOfBitManipulation.swapTwoNumbers();
        BasicInfoOfBitManipulation.checkIfIthBitSetOrNot();
        BasicInfoOfBitManipulation.flipIthBit();
        BasicInfoOfBitManipulation.turnOnIthBit();
        BasicInfoOfBitManipulation.turnOffIthBit();
        BasicInfoOfBitManipulation.checkPowerOf2();
        BasicInfoOfBitManipulation.convertUpperToLower();
        BasicInfoOfBitManipulation.convertLowertoUpper();
        BasicInfoOfBitManipulation.findMaxAndMin();
        BasicInfoOfBitManipulation.countSetBits();
        BasicInfoOfBitManipulation.countLeadingZeros();
        BasicInfoOfBitManipulation.countTrailingZeros();
    }
}
