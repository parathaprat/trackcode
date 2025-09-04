/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        //level order traversal, but we put the right node in before left
        //add first nodes from each level to res

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return res;

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode node = q.poll();
                
                if(i == 0) res.add(node.val);

                if(node.right != null) q.add(node.right);
                if(node.left != null) q.add(node.left);
            }
        }

        return res;
    }
}