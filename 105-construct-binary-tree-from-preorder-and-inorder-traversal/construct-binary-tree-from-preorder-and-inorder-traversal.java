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

    //make gloabl variables for tracking pre and in
    int preInd = 0;
    int inInd = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //last value == limit, determines the partition that divides left and right subtree in inorder
        return dfs(preorder, inorder, Integer.MAX_VALUE);

    }

    public TreeNode dfs(int[] preorder, int[] inorder, int limit){

        //base-> if preInd > pre.len return null
        if(preInd >= preorder.length) return null;

        //to stop building left subtree, null when inorder element == limit (everything to left of limit is left ST & rigth is right ST)
        if(inorder[inInd] == limit){

            //to build right subtree, we have to move past the limit
            inInd++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preInd]);
        preInd++;

        root.left = dfs(preorder, inorder, root.val); //set limit == root.val to build the left subtree
        root.right = dfs(preorder, inorder, limit); // leave limit since inInd has been ++ till after limit to build right subtree

        return root;


    }
}