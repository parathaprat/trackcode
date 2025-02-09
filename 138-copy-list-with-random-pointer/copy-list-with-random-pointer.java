/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        //map of nodes and copies
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;

        //1st pass -> make nodes
        while(cur != null){

            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;

        }

        //2nd pass -> make links

        cur = head;
        while(cur != null){

            Node copy = map.get(cur);
            
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);

            cur = cur.next;

        }

        return map.get(head);
    

    }
}