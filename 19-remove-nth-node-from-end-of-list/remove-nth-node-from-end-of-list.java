/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode slow = temp;
        ListNode fast = temp;

        //move fast n times -> length left = (len - n)
        for(int i = 0; i < n + 1; i++){
            fast = fast.next;
        }

        //make fast travel uptil null, (len - n); therefore slow travels (len - n), stopping at n from the end
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        //skipping the node
        slow.next = slow.next.next;

        return temp.next;
    }
}