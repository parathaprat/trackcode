class Solution {
    public int maxWidthRamp(int[] nums) {
        
        //monotonic decreasing stack 

        Stack<Integer> st = new Stack<>();

        int ans = 0;

        for(int i = 0; i < nums.length; i++){

            if(st.isEmpty() || nums[i] < nums[st.peek()]){

                //push index since we are concerned with diff of indexes
                st.push(i);
            }
        }

        for(int i = nums.length - 1; i >= 0; i--){

            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){

                ans = Math.max(ans, i - st.pop());
            }
        }

        return ans;
    }
}