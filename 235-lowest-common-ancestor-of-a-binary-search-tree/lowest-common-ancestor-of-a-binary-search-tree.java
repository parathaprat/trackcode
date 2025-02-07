/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //approach -> use a tracker node, go left if both are lower and right if both are greater
        TreeNode currNode = root;

        while(currNode != null){
            if(p.val > currNode.val && q.val > currNode.val){
                currNode = currNode.right;
            }

            else if(p.val < currNode.val && q.val < currNode.val){
                currNode = currNode.left;
            }
            else{
                return currNode;
            }
        }

        return null;
    }
}