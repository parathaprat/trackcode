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

    //declare global variables
    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        getAns(root, k);
        return ans;

    }

    //recursive calls made so that count is ++ at every step
    public void getAns(TreeNode node, int k){

        //go to the leftmost/smallest value in the tree if it exists -> get kth smallest element from left subtree while count is global
        if(node.left != null){
            getAns(node.left, k);
        }

        //increase count once smallest value has been reached
        count++;

        //check if count is == k, if it is return ans
        if(count == k){
            ans = node.val;
            return;
        }

        //last option -> to move right -> get kth smallest element from right subtree while count is global
        if(node.right != null){
            getAns(node.right, k);
        }
    }
}