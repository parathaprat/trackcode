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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        slow = reverse(slow);

        fast = head;

        //slow -> start of reversed 2nd half
        //fast -> start of first half

        while(slow != null && fast != null){

            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;


    }

    public ListNode reverse(ListNode node){

        ListNode prev = null;

        while(node != null){

            ListNode next = node.next;

            node.next = prev;
            prev = node;
            node = next;

        }

        return prev;
    }
}