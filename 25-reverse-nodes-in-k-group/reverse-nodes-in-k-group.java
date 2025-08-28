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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null){

            //gets the kthNode from current standing
            ListNode kthNode = getKthNode(temp, k);

            //is there dont exist enough nodes, then connect rest of the list to temp
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }

            //save next node after kth, and dissconnect it to reverse from temp to kth
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseLinkedList(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }

    private ListNode reverseLinkedList(ListNode head){

        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public ListNode getKthNode(ListNode temp, int k){

        k--;

        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }

        return temp;
    }
}