package com.vineethds.subsets;

import java.util.ArrayList;
import java.util.List;
/*
For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

Input: N=2
Output: (()), ()()

Input: N=3
Output: ((())), (()()), (())(), ()(()), ()()()

TC:(N* 2^N)
SC:(N* 2^N)
 */
public class BalancedParenthesisRecursive {

    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<>();
        generateParentheses(num, "",0,0,result);
        return result;
    }

    public static void generateParentheses(int num, String str,int openCount, int closeCount, List<String> result){
        if(openCount == num && closeCount == num){
            result.add(str);
        }else{
            if(openCount < num){
                generateParentheses(num, str+"(",openCount + 1, closeCount, result);
            }
            if(openCount > closeCount){
                generateParentheses(num, str+")",openCount, closeCount + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = BalancedParenthesisRecursive.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = BalancedParenthesisRecursive.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
