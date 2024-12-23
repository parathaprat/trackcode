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
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        //BFS traversal using q
        while(!q.isEmpty()){

            TreeNode curr = q.peek();
            int size = q.size();

            for(int i = 0; i < size; i++){
                curr = q.remove();

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }

            }

            int[] arr = new int[q.size()];
            int k = 0;

            //add each level into an array, count min swaps and add to count
            for(TreeNode num : q){
                arr[k] = num.val;
                k++;
            }

            count += minSwaps(arr, k);
            
        }

        return count;
    }

    //create a copy of level, sort it and calculate min no of swaps 
    private int minSwaps(int[] arr, int N){

        int ans = 0;

        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        //if an alement is not == sorted array, increate swapcount and swap them
        for(int i = 0; i < N; i++){
            if(arr[i] != temp[i]){
                ans++;

                //in arr, swap element at index i and the element that is at i in temp.
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }

        return ans;
    }

    //basic swapping function
    private void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //basic index finding func
    private int indexOf(int[] arr, int ele){

        for(int i = 0; i < arr.length; i++){

            if(arr[i] == ele) return i;
        }

        return -1;
    }
}