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

    int preInd = 0;
    int inInd = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return getAns(preorder, inorder, Integer.MAX_VALUE);
        
    }

    private TreeNode getAns(int[] preorder, int[] inorder, int limit){

        if(preInd >= preorder.length) return null;

        //approached the end of left subtree, sop return null
        //we are trating the limit as the value itseld
        if(inorder[inInd] == limit){
            inInd++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preInd]);
        preInd++;

        node.left = getAns(preorder, inorder, node.val);
        node.right = getAns(preorder, inorder, limit);

        return node;
    }
}