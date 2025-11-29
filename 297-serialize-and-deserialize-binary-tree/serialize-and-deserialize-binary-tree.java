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

    //preorder trav with N for serialize

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder res = new StringBuilder();
        dfs1(res, root);
        return res.toString();
    }

    private void dfs1(StringBuilder res, TreeNode root){

        if(root == null){
            res.append("N ");
            return;
        }

        res.append(root.val + " ");

        dfs1(res, root.left);
        dfs1(res, root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] str = data.split(" ");
        int[] i = {0};

        return dfs2(str, i);
    }

    private TreeNode dfs2(String[] str, int[] i){

        if(str[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str[i[0]]));
        i[0]++;

        node.left = dfs2(str, i);
        node.right = dfs2(str, i);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));