/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        //base case
        if(node == null) return null;

        //map stores node.val (orginal) && node(copy)
        Map<Integer, Node> map = new HashMap<>();

        return cloneGraph(node, map);
    }

    //returns cloned nodes
    public Node cloneGraph(Node node, Map<Integer, Node> map){

        if(map.containsKey(node.val)) return map.get(node.val);

        //if map does not already contain a copy for a value, create it and add to map
        Node copy = new Node(node.val);
        map.put(node.val, copy);

        //iterate through its neighbors and create cloned nodes for each
        for(Node neighbor: node.neighbors){

            //adding cloned neighbor node to copied nodes adj list
            copy.neighbors.add(cloneGraph(neighbor, map));

        }

        return copy;
    }
}