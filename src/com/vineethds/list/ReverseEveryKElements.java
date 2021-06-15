package com.vineethds.list;
/*
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

TC: O(N)
SC: O(1)
 */
public class ReverseEveryKElements {

    private static ListNode reverse(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        while(current != null){
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSublist = current;
            ListNode next = null;
            for(int i = 0 ; i < k && current!= null; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;

            }

            if(lastNodeOfPreviousPart  != null){
                lastNodeOfPreviousPart.next = previous;
            }else{
                head = previous;
            }

            if(lastNodeOfSublist  != null){
                lastNodeOfSublist.next = current;
            }
                previous = lastNodeOfSublist;

            for(int i = 0 ; i < k && current!= null; i++){
                previous = current;
                current = current.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
