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

        //helper -> returns replacement subtree
        //helper finds rightMost node in left subtree of node to be deleted, connects the right subtree to it and returns root.left(root deleted, left subtree with right attached returned)

        if(root == null) return null;
        if(root.val == key) return helper(root);

        TreeNode dummy = root;

        while(root != null){

            if(root.val < key){
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
            else{
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root= root.left;
                }
            }
        }

        return dummy;
    }

    private TreeNode helper(TreeNode root){

        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findRight(root.left);

        lastRight.right = rightChild;

        return root.left;
    }

    private TreeNode findRight(TreeNode root){

        if(root.right == null) return root;
        return findRight(root.right);
    }
}