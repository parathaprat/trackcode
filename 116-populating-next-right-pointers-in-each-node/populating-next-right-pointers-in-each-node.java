/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        //approach: build a level order trav, connect all nodes in a level

        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        List<List<Node>> levelOrderTrav = new ArrayList<>();

        while(!q.isEmpty()){

            int size = q.size();
            List<Node> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                Node node = q.poll();
                level.add(node);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            levelOrderTrav.add(level);
        }

        for(List<Node> row : levelOrderTrav){

            for(int i = 0; i < row.size() - 1; i++){
                row.get(i).next = row.get(i + 1);
            }

        }

        return root;
        
    }
}