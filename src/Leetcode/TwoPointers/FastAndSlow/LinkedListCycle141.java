package Leetcode.TwoPointers.FastAndSlow;

import Leetcode.LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 *
 */
  class ListNode1 {
      int val;
      ListNode next;
      ListNode1(int x) {
          val = x;
          next = null;
      }
  }


public class LinkedListCycle141 {

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
}
