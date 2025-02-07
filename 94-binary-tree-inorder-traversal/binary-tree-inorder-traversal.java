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

    List<Integer> inorder;

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();

        inorder = new ArrayList<>();

        getInOr(root);
        return inorder;
        
    }

    public void getInOr(TreeNode node){

        if(node.left != null){
            getInOr(node.left);
        }

        inorder.add(node.val);

        if(node.right != null){
            getInOr(node.right);
        }
    }
}