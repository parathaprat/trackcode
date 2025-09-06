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

    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        getAns(root, k);

        return ans;
    }

    private void getAns(TreeNode node, int k){

        if(node.left != null) getAns(node.left, k);

        count++;

        if(count == k){
            ans = node.val;
        }

        if(node.right != null) getAns(node.right, k);
    }
}