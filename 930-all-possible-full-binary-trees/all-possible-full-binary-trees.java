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
    public List<TreeNode> allPossibleFBT(int n) {

        //n has to be off to create FBT, return empty list
        if(n %2 == 0) return new ArrayList<>();

        //create hashmap to store combination of subtrees
        Map<Integer, List<TreeNode>> memo = new HashMap<>();

        return generateFBT(n, memo);
    }

    //create an helper function to make all posible FBTs
    public List<TreeNode> generateFBT(int n, Map<Integer, List<TreeNode>> memo){

        //if nodes == 1, return a arraylist with a treenode 0
        if(n == 1){
            List<TreeNode> single = new ArrayList<>();
            single.add(new TreeNode(0));
            return single;
        }

        //if subtrees for an n already exists in map, return from map
        if (memo.containsKey(n)){
            return memo.get(n);
        }

        //main logic
        List<TreeNode> trees = new ArrayList<>();

        //left +2 because if no of node is not odd, FBT is not possible
        for(int left = 1; left < n; left = left + 2){

            //create subtrees from each left node, each right node will be total nodes - left nodes - 1 for head
            List<TreeNode> leftSubtrees = generateFBT(left, memo);
            List<TreeNode> rightSubtrees = generateFBT(n - left - 1, memo);

            //now for each treenode in each subtree, add it to list (each l with each r since we want all combinations)
            for(TreeNode l : leftSubtrees){
                for(TreeNode r : rightSubtrees){
                    TreeNode root = new TreeNode(0, l, r);
                    trees.add(root);
                }
            }
        }

        //add the combination to our map and return to main func
        memo.put(n, trees);
        return trees;
    }
}