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

        //find leftMost of right subtree, connect left subtree to it

        if(root == null) return null;
        if(root.val == key) return remove(root);

        TreeNode dummy = root;

        while(root != null){
            if(key < root.val){

                if(root.left != null && root.left.val == key){
                    root.left = remove(root.left);
                }
                else{
                    root = root.left;
                }
            }     
            else{

                if(root.right != null && root.right.val == key){
                    root.right = remove(root.right);
                } 
                else{
                    root = root.right;
                }
            }  
        }

        return dummy; 
    }

    private TreeNode remove(TreeNode node){

        if(node.left == null) return node.right;
        if(node.right == null) return node.left;

        TreeNode leftSubtree = node.left;
        TreeNode leftMost = findLeftMost(node.right);

        leftMost.left = leftSubtree;

        return node.right;
    }

    private TreeNode findLeftMost(TreeNode node){

        if(node.left == null) return node;
        return findLeftMost(node.left);
    }
}