package Leetcode.TwoPointers.FastAndSlow;

public class DeleteMiddleNode2095 {


    public ListNode deleteMiddle(ListNode head) {

        //initialize two pointers, fast and slow both starting at head
        //Slow trail is going to be following slow, this accomplishes n/2
        ListNode slowTrail = null;
        ListNode slow = head;
        ListNode fast = head;

        //Iterate through the linked list while fast isnt null, time complexity o(n) iterating thru node
        //The reason why we need to do fast and fast's next is because we do not want to iterate to a null value
        //you cannot dereference a null value
        while(fast != null && fast.next != null){
            slowTrail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //now we connect slowTrail with slow.next
        //if slowtrail is still null
        //fast.next was null meaning, theres only 1 node, just return null (at first i had head but its null)
        if(slowTrail == null){
            return slowTrail;
        }

        //"deleting" the node, just replacing it, garbage collector in java deletes the memory allocation
        slowTrail.next = slow.next;
        return head;

        //o(N) time complexity
        //o(1) space complexity
    }
}
