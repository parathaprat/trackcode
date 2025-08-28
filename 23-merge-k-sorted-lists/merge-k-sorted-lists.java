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
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);
            }
        }

        ListNode temp = new ListNode(0);
        ListNode cur = temp;

        while(!minHeap.isEmpty()){

            ListNode node = minHeap.poll();

            if(node.next != null) minHeap.add(node.next);

            cur.next = node;
            cur = cur.next;
        }

        return temp.next;
    }
}