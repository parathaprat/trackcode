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

    //define ans list globally
    List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {
        
        result = new ArrayList<>();

        dfs(root, 0);

        return result;
    }

    //main logic -> dfs
    public void dfs(TreeNode root, int level){

        if(root != null){

            int val = root.val;

            //if level is being encoutered for the first time, add that node's val as max
            if(level == result.size()){
                result.add(val);
            }

            //if not the first time, check if current if higher and had max at index level
            else{
                result.set(level, Math.max(result.get(level), val));
            }

            //carry of the dfs for leaf nodes while increasing level
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}