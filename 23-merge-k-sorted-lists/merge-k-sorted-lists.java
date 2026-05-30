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

        //add heads to pq
        //add next to pq
        //connect with a dummy + tracker

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        ListNode temp = new ListNode(0);
        ListNode cur = temp;

        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }

        while(!pq.isEmpty()){

            ListNode next = pq.poll();

            if(next.next != null) pq.add(next.next);

            cur.next = next;
            cur = cur.next;
        }

        return temp.next; 
    }
}