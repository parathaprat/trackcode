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

    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = buildGraph(preorder, 0, inorder.length - 1, map);

        return root;
    }

    private TreeNode buildGraph(int[] preorder, int start, int end, Map<Integer, Integer> map){

        if(start > end) return null;

        int rootVal = preorder[preorderIndex++];
        int inorderIndex = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = buildGraph(preorder, start, inorderIndex - 1, map);
        root.right = buildGraph(preorder, inorderIndex + 1, end, map);

        return root;
    }
}