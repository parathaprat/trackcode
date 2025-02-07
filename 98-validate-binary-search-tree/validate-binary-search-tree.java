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
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValid(TreeNode root, long min, long max){

        //base -> return true when node approaches null
        if(root == null) return true;

        //if at any point, BST condition is not satisfied, send false
        if(root.val <= min || root.val >= max) return false;

        //if it is satisfied, send to children with adjustments in min and max
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);

    }
}