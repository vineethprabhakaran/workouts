package com.vineethds.list;

class DetectLoopNode{
    int data;
    DetectLoopNode next;
    DetectLoopNode( int data){
        this.data = data;
        next = null;
    }
}


public class DetectAloop {
    private DetectLoopNode head;


    private void insertNodeAtHead(int i) {
        DetectLoopNode node = new DetectLoopNode(i);
        if(head ==  null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    private void detectloop(DetectLoopNode head) {
        DetectLoopNode fast = head;
        DetectLoopNode slow = head;

        while(fast != null && fast.next != null){//important condition
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast != slow){
            System.out.println("Loop Not Found");
            return;
        }else{
            System.out.println("Loop Found");
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println("THe starting pointing of the loop is "+slow.data);
    }

    public static void main(String args[]){
     DetectAloop dal = new DetectAloop();
     dal.insertNodeAtHead(10);
     dal.insertNodeAtHead(4);
     dal.insertNodeAtHead(15);
     dal.insertNodeAtHead(20);
     dal.insertNodeAtHead(50);
     dal.head.next.next.next.next.next = dal.head.next.next;
     /*
      50 -> 20 -> 15 -> 4 -> 10
                   |___________|

      */
     dal.detectloop(dal.head);
    }
}

