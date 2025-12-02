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

    int ans = 0;

    public int maxDepth(TreeNode root) {

        dfs(root, 1);

        return ans;
        
    }

    private void dfs(TreeNode node, int level){

        if(node == null) return;

        ans = Math.max(level, ans);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

        return;
    }
}