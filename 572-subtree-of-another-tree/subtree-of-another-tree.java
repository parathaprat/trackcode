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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //base -> if root is null, direct return false
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;

        //give tree is not a guaranteed BST, so we will have to explore all nodes in root recursively
        //recursively call this function on right and left so they get checked
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q){

        if(p == null && q == null) return true;
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}