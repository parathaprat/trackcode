class Solution {
    public int largestRectangleArea(int[] heights) {
        
        //use stack to keep track of heights
        //run loop, add height to a monotonic increasing stack
        //if shorter stack is excountered, while loop all areas and update
        //same while loop again with end as right boundary for remaining 

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){

            //<= to account for counting max height
            while(st.peek() != -1 && heights[i] <= heights[st.peek()]){

                int h = heights[st.pop()];
                int w = i - st.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }

            st.push(i);
        }

        //remaining bars
        while(st.peek() != -1){
            int h = heights[st.pop()];
            int w = heights.length - st.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }
}