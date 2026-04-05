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

        if(root == null) return 0;

        getSum(root);
        return sum;
    }

    private int getSum(TreeNode node){

        if(node == null) return 0;

        //get left and right pathsums// can be -ve
        int leftSum = Math.max(0, getSum(node.left));
        int rightSum = Math.max(0, getSum(node.right));

        //include
        sum = Math.max(sum, node.val + leftSum + rightSum);

        //not include
        return node.val + Math.max(leftSum, rightSum);
    }
}