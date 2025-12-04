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

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        dfs(root, 1);

        return maxDepth;

    }

    private void dfs(TreeNode root, int curDepth){

        if(root == null) return;

        maxDepth = Math.max(curDepth, maxDepth);

        dfs(root.left, curDepth + 1);
        dfs(root.right, curDepth + 1);
    }
}