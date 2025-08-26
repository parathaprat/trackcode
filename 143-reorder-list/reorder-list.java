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
    public void reorderList(ListNode head) {
        
        //slow and fast pointers
        //reverse 2nd half
        //join thrm

        if(head == null || head.next == null) return;

        //head and tail of first half;
        ListNode l1 = head;
        ListNode prev = null;

        //head and tail of 2nd half
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }

        prev.next = null;

        ListNode l2 = reverse(slow);

        merge(l1, l2);
    }

    private ListNode reverse(ListNode head){

        ListNode prev = null;

        while(head != null){

            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;

        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2){

        while(l1 != null){

            ListNode l1next = l1.next;
            ListNode l2next = l2.next;

            l1.next = l2;

            if(l1next == null) break;

            l2.next = l1next;

            l1 = l1next;
            l2 = l2next;
        }
    }
}