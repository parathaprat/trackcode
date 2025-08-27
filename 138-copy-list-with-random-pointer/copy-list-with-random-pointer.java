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
        
        //make a Map<node, node>
        //1st pass = make copy nodes
        //2nd pass = make connections 

        Map<Node, Node> map = new HashMap<>();

        Node track = head;

        //1st pass = copy nodes and add to map
        while(track != null){

            Node node = new Node(track.val);
            map.put(track, node);
            track = track.next;

        }

        track = head;

        while(track != null){

            Node copy = map.get(track);
            copy.next = map.get(track.next);
            copy.random = map.get(track.random);

            track = track.next;
        }

        return map.get(head);
    }
}