package com.vineethds.subsets;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

Input: N=2
Output: (()), ()()

Input: N=3
Output: ((())), (()()), (())(), ()(()), ()()()

TC:(N* 2^N)
SC:(N* 2^N)
 */
class ParenthesisString{
    String str;
    int openCount;
    int closeCount;
    public ParenthesisString(String str, int openCount, int closeCount){
        this.str = str;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

public class BalancedParenthesis {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        Queue<ParenthesisString> queue = new LinkedList<>();
        queue.add(new ParenthesisString("", 0, 0));
        while(!queue.isEmpty()){
            ParenthesisString p = queue.poll();
            if(p.openCount == num && p.closeCount == num){
                result.add(p.str);
            }else{
                if(p.openCount < num){
                    queue.add(new ParenthesisString(p.str + "(",p.openCount+1,p.closeCount));
                }
                if(p.openCount > p.closeCount){
                    queue.add(new ParenthesisString(p.str+")",p.openCount,p.closeCount+1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = BalancedParenthesis.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = BalancedParenthesis.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
