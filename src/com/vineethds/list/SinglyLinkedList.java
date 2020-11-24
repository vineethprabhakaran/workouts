package com.vineethds.list;

public class SinglyLinkedList<T> {
    public class Node{
        T data;
        Node next;
    }
    Node head;
    int size;
    SinglyLinkedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtEnd(T data){

        if(isEmpty()){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
    }

    public void insertAfter(T data, T previous){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        Node temp = head;
        while(temp != null && !temp.data.equals(previous)){
            temp = temp.next;
        }
        if(temp != null){
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void deleteAtHead(){
        if(isEmpty()){
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteAfterValue(T data){
        if(isEmpty()){
            return;
        }
        Node curr = head;
        Node prev = null;
        if(curr.data.equals(data)){
            deleteAtHead();
            return;
        }
        while(curr != null){
            if(curr.data.equals(data)){
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head;
        System.out.print("List : ");
        while (temp.next != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.printList();
        list.deleteAtHead();
        list.printList();
        list.deleteAfterValue(3);
        list.printList();

    }
}
