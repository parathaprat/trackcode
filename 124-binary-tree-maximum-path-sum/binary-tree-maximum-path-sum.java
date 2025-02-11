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

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        
        getPathSum(root);

        return sum;
    }

    public int getPathSum(TreeNode node){

        if(node == null) return 0;

        int leftSum = Math.max(0, getPathSum(node.left));
        int rightSum = Math.max(0, getPathSum(node.right));

        //2cases -> node involved, node not involved

        sum = Math.max(sum, node.val + leftSum + rightSum);
        
        return node.val + Math.max(leftSum, rightSum);

    }
}