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

        //add all heads to minHeap, pop, add nest and append to res
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode temp = new ListNode(0);
        ListNode cur = temp;

        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }

        while(!pq.isEmpty()){

            ListNode node = pq.poll();
            if(node.next != null) pq.add(node.next);

            cur.next = node;
            cur = cur.next;
        }

        return temp.next;
    }
}