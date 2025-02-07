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

    //declare maxPathSum globally 
    int maxPathSum;

    public int maxPathSum(TreeNode root) {
        
        maxPathSum = Integer.MIN_VALUE;
        
        pathSum(root);

        return maxPathSum;

    }

    public int pathSum(TreeNode root){

        if(root == null) return 0;

        int leftSum = Math.max(0, pathSum(root.left));
        int rightSum = Math.max(0, pathSum(root.right));

        //break at curr node 
        maxPathSum = Math.max(maxPathSum, root.val + leftSum + rightSum);

        //return maxSum
        return root.val + Math.max(leftSum, rightSum);
    }
}