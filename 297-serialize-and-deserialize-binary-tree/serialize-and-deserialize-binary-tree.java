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
        
        //DFS approach with a stringBuilder
        StringBuilder res = new StringBuilder();

        //call recursive DFS function
        dfs1(res, root);

        //return stringBuilder in string form
        return res.toString();
    }

    public void dfs1(StringBuilder res, TreeNode node){

        //if null// end of leaf nodes appear, add an N
        if(node == null){
            res.append("N ");
            return;
        }

        //if node, add the value to sb
        res.append(node.val + " ");

        //call on left and right children for preorder traversal
        dfs1(res, node.left);
        dfs1(res, node.right);


    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        //split values from " ", and create string array
        String[] vals = data.split(" ");

        int[] i = {0};
        return dfs2(vals, i);

    }

    private TreeNode dfs2(String[] vals, int[] i){

        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        
        //no change since i++ was done before
        node.left = dfs2(vals, i);
        node.right = dfs2(vals, i);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));