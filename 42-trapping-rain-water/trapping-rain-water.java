class Solution {
    public int trap(int[] height) {
        
        //main logic -> Min(Max(left, right)) - height

        int left = 0; 
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];

        int ans = 0;

        while(left < right){

            if(leftMax < rightMax){

                left++;
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
            }
            else{

                right--;
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
            }
        }

        return ans;
    }
}