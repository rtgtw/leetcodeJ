package Leetcode.TwoPointers.FastAndSlow;

//Find the middle of the linked list with fast/slow pointer
// reverse the middle of the linked list
//Reverse it back if its true, return false if its not true
//Return true

import Leetcode.LinkedList.ListNode;

public class PalindromeLinkedList234 {


    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;


        //Iterate through the Linked List
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Fast is either Null or at the last node
        //Slow is in the middle of the linked list

        ///Reverse slow, equal slow to this value b/c it will return prev into slow
        slow = this.reverseLinkedList(slow);

        //Move fast back to the head of the linkedList
        fast = head;

        //this while loop iterates through the linked list, if it breaks then its true based on if statement inside
        while(slow != null ){
            if(fast == slow){
                return true;
            }
            if(slow.val != fast.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        //slow is either null or equal to fast which means its odd, its true
        return true;

    }

    //Create a method to reverse the linked list
    public ListNode reverseLinkedList(ListNode middle) {
        ListNode prev = null;
        ListNode current = middle;
        ListNode next;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }


    public static void main(String args[]) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);

        PalindromeLinkedList234 sol = new PalindromeLinkedList234();

        System.out.println(sol.isPalindrome(head));

        //Time complexity = o(n)
        //space complexity = o(1)
        //This is nota easy problem

    }

}
