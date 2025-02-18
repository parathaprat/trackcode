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
        
        //do it with DFS using pre order trav

        StringBuilder res = new StringBuilder();

        dfs1(root, res);

        return res.toString();
        
    }

    private void dfs1(TreeNode node, StringBuilder res){

        //every "N " char it the preorder trav represents a null node
        //we return since there will not be any children here 
        if(node == null){
            res.append("N ");
            return;
        }

        //every nodes call is appended, then left and rigth is called
        res.append(node.val + " ");

        dfs1(node.left, res);
        dfs1(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //build a Strign array split by spaces
        String[] str = data.split(" ");

        //since arrays are passed by ref and ints by value, we use array to track
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