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
        
        Map<Node, Node> map = new HashMap<>();

        Node track = head;

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