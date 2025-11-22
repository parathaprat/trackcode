class Solution {
    public int maxArea(int[] height) {

        //width = right - left
        //height = smaller height be the 2

        //2 pointers, keep track of max maxArea

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){

            if(height[left] < height[right]){

                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;

            }
            else{
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }
        }

        return maxArea;
        
    }
}