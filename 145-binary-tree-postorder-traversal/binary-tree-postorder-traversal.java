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
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();
        
        List<Integer> post = new ArrayList<>();

        getPosty(post, root);

        return post;

    }

    private void getPosty(List<Integer> post, TreeNode node){

        //post -> left, right, center

        if(node.left != null){
            getPosty(post, node.left);
        }

        if(node.right != null){
            getPosty(post, node.right);
        }

        post.add(node.val);
    }
}