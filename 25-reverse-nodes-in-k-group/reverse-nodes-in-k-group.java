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
        
        //split chunks, reverse and join

        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null){

            ListNode kthNode = getKthNode(temp, k);

            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }

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

    private ListNode getKthNode(ListNode node, int k){

        k--;

        while(node != null && k > 0){
            k--;
            node = node.next;
        }

        return node;
    }

    public ListNode reverseLinkedList(ListNode node){

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