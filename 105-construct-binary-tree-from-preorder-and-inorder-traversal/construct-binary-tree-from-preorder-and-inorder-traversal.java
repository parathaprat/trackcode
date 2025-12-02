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

    //global variable to track preorder
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //store inorder in a map for o(1) lookup
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode build(int[] preorder, int inorderStart, int inorderEnd, Map<Integer, Integer> map){

        if(inorderStart > inorderEnd) return null;

        //pick next root from preorder
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        //find index of root in indorder
        int rootPosition = map.get(rootValue);

        root.left = build(preorder, inorderStart, rootPosition - 1, map);
        root.right = build(preorder, rootPosition + 1, inorderEnd, map);

        return root;

    }
}