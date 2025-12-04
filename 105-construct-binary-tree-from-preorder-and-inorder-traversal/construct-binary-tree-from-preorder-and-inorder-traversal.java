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

    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //map to get inorder index in o(1)
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildGraph(preorder, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildGraph(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map){

        if(start > end) return null;

        int nodeIndex = map.get(preorder[preOrderIndex]);

        TreeNode node = new TreeNode(preorder[preOrderIndex]);
        preOrderIndex++;

        node.left = buildGraph(preorder, inorder, start, nodeIndex - 1, map);
        node.right = buildGraph(preorder, inorder, nodeIndex + 1, end, map);

        return node;
    }
}