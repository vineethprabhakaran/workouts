package com.vineethds.others;


import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class StackAsQueue {

    Stack<Integer> stack1 =new Stack<>(10);
    Stack<Integer> stack2 = new Stack<Integer>(10);
    public static void main(String[] args) {
        StackAsQueue sq = new StackAsQueue();

        System.out.println(sq.dequeue());

        int num = 1;
        //sq.enqueue(num);

        System.out.println(sq.dequeue());
        num = 2;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1,1);
        sq.enqueue(num, mp);
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());


    }


    public  void enqueue(int  num, Map<Integer, Integer> hm ){
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 1);
        num = 12;
        hm = mp;
        stack1.push(num);
    }

    public int dequeue(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        if(stack1.isEmpty())
            return -1;

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

}
