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

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<Integer> ans = new ArrayList<>();

        getPathSum(root, 0, targetSum, ans);

        return paths;       
    }

    private void getPathSum(TreeNode node, int sumSoFar, int targetSum, List<Integer> ans){

        if(node == null) return;

        sumSoFar += node.val;
        ans.add(node.val);

        if(node.left == null && node.right == null){

            if(sumSoFar == targetSum) paths.add(new ArrayList<>(ans));

        }

        getPathSum(node.left, sumSoFar, targetSum, ans);
        getPathSum(node.right, sumSoFar, targetSum, ans);

        ans.remove(ans.size() - 1);
    }
}