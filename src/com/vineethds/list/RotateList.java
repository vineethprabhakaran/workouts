package com.vineethds.list;

public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        if (head  == null)
            return head;

        int listsize = 1;
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            listsize++;
        }

        current.next = head;
        rotations %= listsize;
        int skipLength = listsize - rotations;
        ListNode lastNodeOfRotatedList = head;
        for(int i = 0 ; i< skipLength -1;i++){
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
