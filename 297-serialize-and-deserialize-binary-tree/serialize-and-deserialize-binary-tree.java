/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        dfs1(root, sb);
        return sb.toString();
        
    }

    private void dfs1(TreeNode root, StringBuilder sb){

        if(root == null){
            sb.append("N ");
            return;
        }

        sb.append(root.val + " ");
        dfs1(root.left, sb);
        dfs1(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] arr = data.split(" ");
        int[] i = {0};

        return dfs2(arr, i);
    }

    private TreeNode dfs2(String[] arr, int[] i){

        if(arr[i[0]].equals("N")){
            i[0]++; 
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[i[0]]));
        i[0]++;

        node.left = dfs2(arr, i);
        node.right = dfs2(arr, i);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));