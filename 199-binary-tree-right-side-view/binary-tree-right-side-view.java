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

        //level order trav, add right node before left
        //first from each level into res

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode cur = q.poll();

                if(i == 0) res.add(cur.val);

                if(cur.right != null) q.add(cur.right);
                if(cur.left != null) q.add(cur.left);
            }
        }

        return res;
    }
}