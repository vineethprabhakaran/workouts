package com.vineethds.list;

import java.util.HashMap;

public class LRU {
    private DoublyLinkedList pageList;
    private HashMap<Integer, ListNode> pageMap;
    private int cacheSize;

    LRU(int size){
        this.cacheSize = size;
        pageList = new DoublyLinkedList(size);
        pageMap = new HashMap<Integer, ListNode>();
    }

    public void accessToPage(int pageNumber){
        if(pageMap.get(pageNumber) != null){
            pageList.moveNodetoHead(pageMap.get(pageNumber));
        }else{

            if(pageList.currSize == pageList.size){
                System.out.println("Cache Full");
                pageMap.remove(pageList.tail.data);
                System.out.println(pageList.tail.data +" Removed");
            }
            ListNode n = pageList.addNodetoList(pageNumber);
            pageMap.put(pageNumber,n);
            System.out.println(pageNumber +" Added");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        LRU l = new LRU(5);
        l.accessToPage(1);
        Thread.sleep(1000);
        l.accessToPage(2);
        Thread.sleep(1000);
        l.accessToPage(3);
        Thread.sleep(1000);
        l.accessToPage(4);
        Thread.sleep(1000);
        l.accessToPage(5);
        Thread.sleep(1000);
        l.accessToPage(6);
        Thread.sleep(1000);
        l.accessToPage(7);
        Thread.sleep(1000);
        l.accessToPage(8);
    }
}

class DoublyLinkedList{
    ListNode head;
    ListNode tail;
    int size;
    int currSize;

    DoublyLinkedList(int size){
        this.size = size;
    }

    public void moveNodetoHead(ListNode listNode) {
        if(listNode == null || listNode == head)
            return;
        if(listNode == tail){
            tail = tail.prev;
            tail.next = null;
        }
        ListNode prev = listNode.prev;
        ListNode next = listNode.next;
        prev.next = next;
        if(next != null){
            next.prev = prev;
        }

        listNode.prev = null;
        listNode.next = head;
        head.prev = listNode;
        head = listNode;
    }

    public ListNode addNodetoList(int pageNumber) {
        ListNode node = new ListNode(pageNumber);
        if(head  == null){
            head = node;
            tail = node;
            currSize = 1;
            return node;
        }else if(currSize < size){
            currSize++;
        }else{
            tail = tail.prev;
        }
        node.next = head;
        head.prev = node;
        head = node;
        return node;
    }
}

class ListNode{
    int data;
    ListNode next;
    ListNode prev;
    ListNode(int data){
        this.data = data;
    }
}