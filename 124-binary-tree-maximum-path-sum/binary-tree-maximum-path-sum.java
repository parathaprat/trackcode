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

    //globally declare sum variable
    int maxPathSum;

    public int maxPathSum(TreeNode root) {

        //assign smallest value to sum
        maxPathSum = Integer.MIN_VALUE;

        getPathSum(root);

        return maxPathSum;
        
    }

    public int getPathSum(TreeNode node){

        //base -> if node is null, path sum = 0
        if(node == null) return 0;

        //path sum of subtrees may be -ve, so max bw getPathSum and 0
        int leftSum = Math.max(0, getPathSum(node.left));
        int rightSum = Math.max(0, getPathSum(node.right));

        //now we have the maxPathSum of left and right subtrees -> 
        //cases -> breaks at node and does not break at node
        
        //breaks at node -> left + right + node; also update maxPathSum
        maxPathSum = Math.max(maxPathSum, leftSum + rightSum + node.val);

        //return node.val + max(left, right)
        return node.val + Math.max(leftSum, rightSum);
    }


}