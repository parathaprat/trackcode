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
        
        //arrange heads of lists in ascending order
        //main logic -> poll from heap, add next from list, keep going
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists){

            if(node != null) minHeap.add(node);

        }

        //pre head
        ListNode temp = new ListNode(0);

        //iterator
        ListNode curr = temp;

        while(!minHeap.isEmpty()){
            //add next node from top of list to minHeap, then add it to curr.next

            ListNode next = minHeap.poll();

            if(next.next != null) minHeap.add(next.next);

            curr.next = next;
            curr = curr.next;
            
        }

        return temp.next;


    }
}