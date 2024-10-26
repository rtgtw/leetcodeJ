package Leetcode.TwoPointers.FastAndSlow;


//To find the middle of the linked list you just use a fast and slow pointer
//1 and 2 speed

import Leetcode.LinkedList.ListNode;

public class MiddleOfLinkedList876 {


    public ListNode middleNode(ListNode head){
        //return the middle node
        //initialize two pointers, fast and slow both starting at head
        ListNode slow = head;
        ListNode fast = head;

        //Iterate through the linked list while fast isnt null, time complexity o(n) iterating thru node
        //The reason why we need to do fast and fast's next is because we do not want to iterate to a null value
        //you cannot dereference a null value
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Now all we have to do is return slow

        return slow;
    }

    public ListNode middleNodeN(ListNode head){
        //return the middle node
        //initialize two pointers, fast and slow both starting at head
        ListNode slow = head;
        ListNode fast = head;

        //Iterate through the linked list while fast isnt null, time complexity o(n) iterating thru node
        //The reason why we need to do fast and fast's next is because we do not want to iterate to a null value
        //you cannot dereference a null value
        while(fast != null && fast.next != null){
            //Move fast, and if fast is already at null just return slow
            fast = fast.next.next;

            if(fast != null && fast.next != null){
                slow = slow.next;
            }else{
                return slow;
            }
        }

        //Now all we have to do is return slow

        return slow;
    }


    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        MiddleOfLinkedList876 sol = new MiddleOfLinkedList876();

        //show the value of the returned node
        System.out.println(sol.middleNodeN(head).val);

        //Time complexity o(N) just iterating through a linkedList
        //Space complexity o(1) no extra space
    }



}
