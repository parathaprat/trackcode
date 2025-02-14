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

        //1st pass -> create nodes
        Node track = head;

        while(track != null){

            Node copy = new Node(track.val);

            map.put(track, copy);

            track = track.next;

        
        }


        //2nd pass -> connect nodes

        track = head;

        while(track != null){

            Node copy = map.get(track);

            //point to map.get(pointer) since direct assignment makes them point to original list
            copy.next = map.get(track.next);
            copy.random = map.get(track.random);

            track = track.next;
            
        }

        return map.get(head);
    }
}