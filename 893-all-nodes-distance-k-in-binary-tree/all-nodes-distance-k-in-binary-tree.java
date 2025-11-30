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
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        //BFS1: populate parent map
        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode top = q.poll();

                if(top.left != null){
                    parentMap.put(top.left.val, top);
                    q.add(top.left);
                }

                if(top.right != null){
                    parentMap.put(top.right.val, top);
                    q.add(top.right);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();

        q.add(target); //BFS2: from target to dist k

        while(k > 0 && !q.isEmpty()){

            int size = q.size();
            
            for(int i = 0; i < size; i++){

                TreeNode top = q.poll();
                visited.add(top.val);

                if(top.left != null && !visited.contains(top.left.val)){
                    q.add(top.left);
                }

                if(top.right != null && !visited.contains(top.right.val)){
                    q.add(top.right);
                }

                if(parentMap.containsKey(top.val) && !visited.contains(parentMap.get(top.val).val)){
                    q.add(parentMap.get(top.val));
                }
            }

            k--;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }
}