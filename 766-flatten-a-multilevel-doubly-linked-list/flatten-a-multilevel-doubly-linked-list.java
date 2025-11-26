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

        Node cur = head;

        while(cur != null){

            if(cur.child != null){

                Node childLast = cur.child;
                while(childLast.next != null) childLast = childLast.next;

                childLast.next = cur.next;
                if(cur.next != null) cur.next.prev = childLast;

                cur.next = cur.child;
                cur.child.prev = cur;
                
                cur.child = null;
            }

            cur = cur.next;
        }

        return head;
        
    }
}