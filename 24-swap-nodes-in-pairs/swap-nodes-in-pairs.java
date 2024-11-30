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
    public ListNode swapPairs(ListNode head) {
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;

        while(current.next != null && current.next.next != null){
            //get 1st and 2nd nodes in list
            ListNode first = current.next;
            ListNode second = current.next.next;

            //make 1 point to what 2 was pointing towards
            first.next = second.next;

            //make 2 point to 1
            second.next = current.next;

            //make 2 start of list
            current.next = second;

            //jump 2 steps and continue loop
            current = current.next.next;

        }

        return temp.next;
    }
}