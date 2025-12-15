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

    List<Integer> inorder= new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        dfs(root);
        
        return inorder.get(k - 1);
    }

    private void dfs(TreeNode root){

        if(root == null) return;

        dfs(root.left);
        inorder.add(root.val);
        dfs(root.right);
    }
}