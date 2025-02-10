class Solution {
    public int trap(int[] height) {
        
        //Min(Max(l, r)) - height

        int l = 0;
        int r = height.length - 1;

        int leftMax = height[l];
        int rightMax = height[r];

        int ans = 0;

        while(l < r){

            if(leftMax < rightMax){

                l++;
                leftMax = Math.max(leftMax, height[l]);
                ans += leftMax - height[l];
            }
            else{

                r--;
                rightMax = Math.max(rightMax, height[r]);
                ans += rightMax - height[r];

            }
        }

        return ans;
    }
}