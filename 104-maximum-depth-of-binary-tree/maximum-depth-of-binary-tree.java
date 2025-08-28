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
    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        return getAns(root);
        
    }

    public int getAns(TreeNode node){

        if(node == null) return 0;

        int leftDepth = 1 + getAns(node.left);
        int rightDepth = 1 + getAns(node.right);

        return Math.max(leftDepth, rightDepth);
    }
}