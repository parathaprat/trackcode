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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //reverse it
        //add digits
        //reverse again and return

        if(l1 == null && l2 == null) return null;

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        int sum = 0;

        ListNode temp = new ListNode(0);
        ListNode cur = temp;

        while(l1 != null || l2 != null || carry != 0){

            sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum%10);
            carry = sum / 10;

            cur.next = node;
            cur = cur.next;
        }
        
        return reverse(temp.next);
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
}