package Leetcode.LinkedList;


import java.util.List;

public class MergeTwoSortedLists21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){

        //create a dummy node
        ListNode head = new ListNode(0);
        ListNode dummy = head;


        while(list1 != null && list2 != null){

            if(list1.val <= list2.val) {
                dummy.next = list1;

                list1 = list1.next;
            }else{
                dummy.next = list2;

                list2 = list2.next;
            }

            dummy = dummy.next;
        }

        //account for any remainders
        if(list1 != null){
            //append the rest of list one to head
            dummy.next = list1;
        }

        if(list2 != null){
            dummy.next = list2;
        }



        //head.next because the init value is a dummy value
        return head.next;
    }




    public static void main(String args[]){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        //time oN
        //space o1
    }
}
