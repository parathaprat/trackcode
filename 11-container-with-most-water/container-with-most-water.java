class Solution {
    public int maxArea(int[] height) {
        
        //2 pointer
        //height limited by smaller bar
        //height in array, width with index

        int left = 0;
        int right = height.length - 1;

        int ans = 0;

        while(left < right){

            if(height[left] < height[right]){

                ans = Math.max(ans, height[left] * (right - left));
                left++;

            }
            else{

                ans = Math.max(ans, height[right] * (right - left));
                right--;
            }
        }

        return ans;
    }
}