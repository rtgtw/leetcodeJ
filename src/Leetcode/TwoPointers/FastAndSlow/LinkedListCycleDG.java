package Leetcode.TwoPointers.FastAndSlow;

//ListNode class create it


class ListNode{
    int val = 0;
    ListNode next;

    ListNode(int value){
        this.val = value;
        this.next = null;
    }
}

public class LinkedListCycleDG {

    public boolean hasCycle(ListNode head){

        //Find if the linkedList has a cycle
        ListNode fast = head;
        ListNode slow = head;

        //traverse the linked list while fast doesnt = null
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        LinkedListCycleDG sol = new LinkedListCycleDG();

        System.out.println(sol.hasCycle(head));

        head.next.next.next.next.next = head.next;

        System.out.println(sol.hasCycle(head));


    }

}
