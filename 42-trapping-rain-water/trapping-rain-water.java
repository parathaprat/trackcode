class Solution {
    public int trap(int[] height) {

        //Min(max(left), right) - height[i];

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int ans = 0;

        while(left < right){

            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left];
            }
            else{
                right--;
                rightMax = Math.max(height[right], rightMax);
                ans += rightMax - height[right];
            }
        }

        return ans;
        
    }
}