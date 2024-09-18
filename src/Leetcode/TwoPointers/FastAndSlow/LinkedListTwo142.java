package Leetcode.TwoPointers.FastAndSlow;


//Find where the cycle begins


public class LinkedListTwo142 {

    //The first thing we have to do is identify if there is a cycle or not

    public ListNode detectCycle(ListNode head){

        //Use fast and slow pointers, if slow catches up to fast then there is a cycle, if not then there isnt a cycle
        ListNode fast = head;
        ListNode slow = head;

        //Iterate the Linked List
        //if there is no linked list or only one node then return null
        if(fast == null || fast.next == null){
            return null;
        }

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            //we want to break because we found where they meet,
            //now just iterate fast by one and return slow to head and the meeting point
            //is the start of the cycle
            if(slow == fast){
                break;
            }
        }
        //return slow to head
        slow = head;

        //Now if fast doesnt equal null, move forward by once and when they equal to each other return
        //if fast does equal null, return null
        if(fast == null || fast.next == null){
            return null;
        }else{
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;

            }
        }

        //can return fast or slow
        return fast;
    }


    public static void main(String args[]){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;


        LinkedListTwo142 sol = new LinkedListTwo142();

        System.out.println(sol.detectCycle(head).val);

    }

}
