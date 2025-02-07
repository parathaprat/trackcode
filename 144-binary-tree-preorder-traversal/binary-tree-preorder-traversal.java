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

    List<Integer> pre;

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();

        pre = new ArrayList<>();

        getTrav(root);

        return pre;
        
    }

    private void getTrav(TreeNode node){

        pre.add(node.val);

        if(node.left != null){
            getTrav(node.left);
        }

        if(node.right != null){
            getTrav(node.right);
        }
    }
}