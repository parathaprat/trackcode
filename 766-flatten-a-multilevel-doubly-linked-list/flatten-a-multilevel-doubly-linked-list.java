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

        //if child, navigate to end of child
        //childlast.next = node.next
        //node.next.prev = childlast
        //node.next = child

        Node cur = head;

        while(cur != null){

            if(cur.child != null){
                
                Node childLast = cur.child;

                while(childLast.next != null) childLast = childLast.next;

                childLast.next = cur.next;
                if(cur.next != null) cur.next.prev = childLast;
                cur.child.prev = cur;
                cur.next = cur.child;

                cur.child = null;
            }

            cur = cur.next;
        }

        return head;
    }
}