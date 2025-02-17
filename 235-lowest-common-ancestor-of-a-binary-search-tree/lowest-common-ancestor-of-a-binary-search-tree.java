/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;

        return getAns(root, p, q);
    }

    private TreeNode getAns(TreeNode node, TreeNode p, TreeNode q){

        if(p.val > node.val && q.val > node.val) return getAns(node.right, p, q);

        if(p.val < node.val && q.val < node.val) return getAns(node.left, p, q);

        return node;
    }
}