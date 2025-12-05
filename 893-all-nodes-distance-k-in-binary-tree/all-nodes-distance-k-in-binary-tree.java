/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        //populate parentMap with first BFS

        while(!q.isEmpty()){

            int level = q.size();

            for(int i = 0; i < level; i++){

                TreeNode cur = q.poll();

                if(cur.left != null){
                    parentMap.put(cur.left, cur);
                    q.add(cur.left);
                }
                if(cur.right != null){
                    parentMap.put(cur.right, cur);
                    q.add(cur.right);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();

        //BFS 2 k times from node target
        q.add(target);

        while(k > 0 && !q.isEmpty()){

            int level = q.size();

            for(int i = 0; i < level; i++){

                TreeNode cur = q.poll();
                visited.add(cur.val);

                if(cur.left != null && !visited.contains(cur.left.val)){
                    q.add(cur.left);
                }

                if(cur.right != null && !visited.contains(cur.right.val)){
                    q.add(cur.right);
                }

                if(parentMap.containsKey(cur) && !visited.contains(parentMap.get(cur).val)){
                    q.add(parentMap.get(cur));
                }
            }

            k--;
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }

        return res;
    }
}