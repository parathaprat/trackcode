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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int i = 0;
        while(!q.isEmpty()){

            int level = q.size();

            List<Integer> ans = new ArrayList<>();

            for(int j = 0; j < level; j++){

                TreeNode node = q.poll();

                ans.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            
            }

            if(i%2 != 0){

                Collections.reverse(ans);

                res.add(ans);

            }
            else{
                res.add(ans);
            }

            i++;



        }

        return res;
    }
}