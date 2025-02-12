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
        
        //DFS -> functiont that can get the sum of all paths from root to leaf;

        return getSum(root, 0);
    }

    private int getSum(TreeNode node, int sumToLeaf){

        if(node == null) return 0;

        sumToLeaf = sumToLeaf * 10 + node.val;

        //if its a leaf node, sent the ans back
        if(node.left == null && node.right == null) return sumToLeaf;

        //pass this down to get sumToLeaf for left and rigth subtrees
        return getSum(node.left, sumToLeaf) + getSum(node.right, sumToLeaf);
    }
}