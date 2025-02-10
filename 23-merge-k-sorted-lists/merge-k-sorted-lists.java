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
        
        //minHeap with the heads of each list, heap always maintians k elements

        //pq sorted ascending 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists){

            if(node != null){
                minHeap.add(node);
            }
        }

        ListNode temp = new ListNode(0);
        ListNode trac = temp;

        while(!minHeap.isEmpty()){

            ListNode node = minHeap.poll();

            if(node.next != null){
                minHeap.add(node.next);
            }

            trac.next = node;

            trac = trac.next;
            
        }

        return temp.next;
    }
}