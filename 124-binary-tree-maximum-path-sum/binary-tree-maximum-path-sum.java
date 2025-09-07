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
        
        getAns(root);
        return sum;
    }

    private int getAns(TreeNode node){

        if(node == null) return 0;

        int leftSum = Math.max(0, getAns(node.left));
        int rightSum = Math.max(0, getAns(node.right));

        sum = Math.max(node.val + leftSum + rightSum, sum);

        return node.val + Math.max(leftSum, rightSum);
    }
}