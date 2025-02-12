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
    public int sumNumbers(TreeNode root) {
        
        int sum = 0;

        //getAns -> sum of all paths from node to leaf
        return getAns(root, sum);
    }

    private int getAns(TreeNode node, int sum){

        if(node == null) return 0;

        //preorder trav, since we want top numbers to be first 
        sum = sum * 10 + node.val;

        //if leaf node appears -> return sum so far
        if(node.left == null && node.right == null) return sum;

        //return sum of all paths from left and right subtree
        return getAns(node.left, sum) + getAns(node.right, sum);

    }
}