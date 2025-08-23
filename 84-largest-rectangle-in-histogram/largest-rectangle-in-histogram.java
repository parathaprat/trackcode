class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){

            while(st.peek() != -1 && heights[i] <= heights[st.peek()]){
                int height = heights[st.pop()];
                int width = i - 1 - st.peek(); //i-1 right; st.peek left
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        while(st.peek() != -1){
            int height = heights[st.pop()];
            int width = heights.length - 1 - st.peek();
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}