package com.vineethds.list;

class ListNodes {
    int value = 0;
    ListNodes next;

    ListNodes(int value) {
        this.value = value;
    }
}
public class PalindromicLinkedList {

    public static boolean isPalindrome(ListNodes head) {
        int numofNodes = 0;
        ListNodes slow = head;
        while(slow != null){
            slow = slow.next;
            numofNodes++;
        }
        slow = head;
        ListNodes fast = head;
        ListNodes prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNodes temp = null;
        if(numofNodes % 2 != 0){
            temp = slow;
            slow = slow.next;
            temp.next = null;
        }
        slow = reverseList(slow);
        fast = head;
        ListNodes node = slow;
        boolean result = true;

        while(fast != null && node != null){
            if(fast.value != node.value){
                result = false;
                break;
            }
            fast = fast.next;
            node = node.next;
        }

        slow = reverseList(slow);
        if(temp != null){
            temp.next = slow;
            slow = temp;
        }
        prev.next = slow;
        return result;
    }

    public static ListNodes reverseList(ListNodes node){
        ListNodes prev = null;
        ListNodes curr = node;
        ListNodes next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        ListNodes head = new ListNodes(2);
        head.next = new ListNodes(4);
        head.next.next = new ListNodes(6);
        head.next.next.next = new ListNodes(4);
        head.next.next.next.next = new ListNodes(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNodes(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
