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
    public TreeNode deleteNode(TreeNode root, int key) {

        //traverse tree, find key
        //find rightmost of left subtree OR leftMost of right subtree
        //rightMostLeft.right = rightST, leftMostRight.left = leftMost
        //return root.left, return root.right

        if(root == null) return null;
        if(root.val == key) return helper(root);

        TreeNode dummy = root;

        while(root != null){

            if(root.val < key){

                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else root = root.right;
            }
            else{

                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else root = root.left;
            }
        }

        return dummy;
        
    }

    private TreeNode helper(TreeNode root){

        if(root.right == null) return root.left;
        if(root.left == null) return root.right;

        TreeNode leftSubtree = root.left;
        TreeNode leftMost = findLeft(root.right);

        leftMost.left = leftSubtree;

        return root.right;
    }

    private TreeNode findLeft(TreeNode root){

        if(root.left == null) return root;
        return findLeft(root.left);
    }
}