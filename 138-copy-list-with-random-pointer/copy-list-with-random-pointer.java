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
        
        //2 pass through our array
        //map {original, copy}
        Map<Node, Node> map = new HashMap<>();

        //to copy nulls
        map.put(null, null);

        //tracker node
        Node cur = head;

        //pass to create copy nodes
        while(cur != null){

            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;

        }

        //pass to create connections

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