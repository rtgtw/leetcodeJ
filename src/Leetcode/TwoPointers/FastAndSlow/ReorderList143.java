package Leetcode.TwoPointers.FastAndSlow;



public class ReorderList143 {



    public ListNode reorderList(ListNode head){
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

        //Different objective for ReorderList vs Palindrome starts here
        ListNode next;

        while(fast != null && fast.next != null){
            next = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
            slow = next;

        }

        return head;

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



    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList143 sol = new ReorderList143();

        ListNode reordered = sol.reorderList(head);

        while(reordered != null){
            System.out.println(reordered.val);
            reordered = reordered.next;
        }
    }
}
