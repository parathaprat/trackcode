class Solution {
    public int maxWidthRamp(int[] nums) {
        
        //number(i) <= number(j) 
        //j > i
        //width = j - i;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < nums.length; i++){

            if(st.isEmpty() || nums[i] < nums[st.peek()]) st.add(i);
        }

        int ans = 0;

        for(int j = nums.length - 1; j >= 0; j--){

            //keep popping until num[j] isnt < num[st.peek()]
            while(!st.isEmpty() && nums[j] >= nums[st.peek()]){
                ans = Math.max(ans, j - st.pop());
            }
        }

        return ans;
    }
}