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
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        //vertical order trav -> nodes to be sorted by col, row, val
        //use min. max to sort by col, and pq to sort by row then val

        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>(); //col -> row, val;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<int[]> meta = new LinkedList<>(); //row, col

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        q.add(root);
        meta.add(new int[]{0, 0});

        //min and max col to iterate through for final res building
        int min = 0;
        int max = 0;

        while(!q.isEmpty()){

            TreeNode node = q.poll();
            int[] rc = meta.poll();

            int row = rc[0];
            int col = rc[1];

            //populate map; pq sorts by row, if same sorts by val
            map.putIfAbsent(col, new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
            map.get(col).add(new int[]{row, node.val});

            //add child nodes to q, and update min and max for traversal later
            if(node.left != null){
                q.add(node.left);
                meta.add(new int[]{row + 1, col - 1});
                min = Math.min(min, col - 1);
            }

            if(node.right != null){
                q.add(node.right);
                meta.add(new int[]{row + 1, col + 1});
                max = Math.max(max, col + 1);
            }
        }

        for(int i = min; i <= max; i++){

            PriorityQueue<int[]> pq = map.get(i);
            List<Integer> list = new ArrayList<>();

            while(!pq.isEmpty()){
                list.add(pq.poll()[1]);
            }

            res.add(list);
        }

        return res;
    }
}