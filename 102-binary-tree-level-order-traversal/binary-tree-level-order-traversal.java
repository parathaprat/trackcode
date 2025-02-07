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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //q and list required
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ansList = new ArrayList<>();

        if(root == null) return new ArrayList<>();

        q.add(root);

        getLevelOrd(q, ansList);

        return ansList;

    }

    public void getLevelOrd(Queue<TreeNode> q, List<List<Integer>> ansList){

        while(!q.isEmpty()){

            //maintain level size for popping
            int levelSize = q.size();

            //list gets reset at every iteration/ level
            List<Integer> thisLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){

                //get nodes at that level and add to list
                TreeNode node = q.poll();

                thisLevel.add(node.val);

                //if left and right are not null, add to q
                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }

            }

            //add that particular level to final list
            ansList.add(thisLevel);
        }
    }




}