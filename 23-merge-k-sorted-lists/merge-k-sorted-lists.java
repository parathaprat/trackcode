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
    public ListNode mergeKLists(ListNode[] lists) {

        //custom comparator minHeap to hold k listnodes at a time
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        //add all heads to minHeap
        for(ListNode head : lists){

            if(head != null){
                minHeap.add(head);
            }

        }

        //temp head and iterator
        ListNode temp = new ListNode(-1);
        ListNode currentNode = temp;

        //main logic -> set next node, add its next to minHeap, maintaining k nodes in heap at a time
        while(!minHeap.isEmpty()){

            ListNode nextMinNode = minHeap.poll();
            currentNode.next = nextMinNode;
            currentNode = currentNode.next;

            //if next of nextMinNode is != null, add to minHeap (will get auto sorted)
            if(nextMinNode.next != null){

                minHeap.add(nextMinNode.next);

            }

        }

        return temp.next;
    }
}