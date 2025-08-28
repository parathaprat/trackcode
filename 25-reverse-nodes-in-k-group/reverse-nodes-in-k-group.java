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
        
        //keep track of head (temp) and tail (prevLast) of each group
        //reverse group
        //join again
        //handle cases where k nodes do not exists 

        ListNode temp = head;
        ListNode prevLast = null;
        
        while(temp != null){

            ListNode kthNode = getKthNode(temp, k);

            //case where k nodes do not exist
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }

            //diconnect, store and reverse
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseLinkedList(temp);

            //case where temp is on the first chunck, vs others
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

    public ListNode reverseLinkedList(ListNode head){

        ListNode prev = null;

        while(head != null){

            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public ListNode getKthNode(ListNode node, int k){

        k--;

        while(node != null && k > 0){
            k--;
            node = node.next;
        }

        return node;
    }
}