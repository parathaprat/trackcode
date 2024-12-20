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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();

        int level = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            
            int size = queue.size();

            ArrayList<TreeNode> list = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

                if(level % 2 != 0){
                    list.add(node);
                }
            }

            if(level % 22 != 0){
                int l = 0;
                int r = list.size() - 1;

                while(l < r){
                    int temp = list.get(l).val;
                    list.get(l).val = list.get(r).val;
                    list.get(r).val = temp;
                    l++;
                    r--;
                }

            }

            level++;
        }

        return root;
    }
}