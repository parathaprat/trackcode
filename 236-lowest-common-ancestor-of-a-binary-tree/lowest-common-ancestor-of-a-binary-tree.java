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

        if(node == null) return null;

        if(node == p || node == q) return node;

        TreeNode left = getAns(node.left, p, q);
        TreeNode right = getAns(node.right, p, q);

        if(left != null && right != null) return node;

        return left == null ? right : left;
    }
}