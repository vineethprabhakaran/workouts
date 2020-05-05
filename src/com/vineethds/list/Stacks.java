package com.vineethds.list;
/*
 Stack data structure - Last In First Out
 Time Complexity - O(N) where N - number of elements in stack
 Space Complexity - O(1)
 */
public class Stacks {
    LinkedNode head;
    int size;
    //Singly Linked List
    class LinkedNode{
        int data;
        LinkedNode next;
        LinkedNode(int data){
            this.data = data;
        }
    }

    public void push(int data){
        LinkedNode node = new LinkedNode(data);
        if(head != null){
            node.next = head;
        }
        head = node;
        size++;
    }

    public LinkedNode pop(){
        LinkedNode node = head;
        if(head != null){
            head = head.next;
            node.next = null;
            size--;
        }else{
            System.out.println("No Elements in stack");
        }
        return node;
    }

    public int size(){
        return  size;
    }

    public void printNodes(){
        LinkedNode ptr = head;
        while(ptr != null){
            System.out.print(ptr.data);
            if(ptr.next != null)
                System.out.print(" --> ");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    public static void main(String[] arg){
        Stacks st = new Stacks();
        st.push(20);
        st.push(30);
        st.push(40);
        st.printNodes();
        System.out.println(st.size());
        st.pop();
        st.printNodes();
        System.out.println(st.size());
    }
}
