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
        
        //maintian count
        //traverse left
        //increase count, when count == k, return
        //traverse right

        
        getAns(root, k);
        return ans;
    }

    public void getAns(TreeNode node, int k){

        if(node.left != null) getAns(node.left, k);

        count++;

        if(count == k){
            ans = node.val;
            return;
        }

        if(node.right != null) getAns(node.right, k);
    }


}