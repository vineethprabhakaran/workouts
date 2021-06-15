package com.vineethds.arrays;

import com.vineethds.others.Stack;

/*
input: arr = {4,6,3,2,8,1}
output: {6,8,8,8,-1,-1}
 */
public class NextGreaterChallenge {

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int n  = arr.length;
        Stack<Integer> stack = new Stack<Integer>(n);
        stack.push(0);

        for(int i = 1; i< n ; i++){
            while(!stack.isEmpty() && arr[stack.top()] < arr[i]){
                int num = stack.pop();
                result[num] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int num = stack.pop();
            result[num] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4,6,3,2,8,1};
        int[] res = nextGreaterElement(arr);
        for(int a : res){
            System.out.print(a +" ");
        }

    }
}
