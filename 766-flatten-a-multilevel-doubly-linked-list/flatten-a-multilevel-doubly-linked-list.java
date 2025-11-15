/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        //traverse with a cur
        //if child, store next, find child tail
        //childTail.next = next; next.prev to child tail
        //cur.next to child

        if(head == null) return null;

        Node cur = head;

        while(cur != null){

            if(cur.child != null){

                Node next = cur.next;
                Node childLast = cur.child;

                while(childLast.next != null) childLast = childLast.next;

                if(next != null){
                    childLast.next = next;
                    next.prev = childLast;
                }

                cur.child.prev = cur;
                cur.next = cur.child;
                cur.child = null;

            }

            cur = cur.next;
        }

        return head;
    }
}