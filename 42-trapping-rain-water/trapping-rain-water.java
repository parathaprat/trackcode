class Solution {
    public int trap(int[] height) {

        //Min(max(left), max(right) - height)

        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        int ans = 0;

        while(left < right){

            if(maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                ans += maxLeft - height[left];
            }
            else{
                right--;
                maxRight = Math.max(maxRight, height[right]);
                ans += maxRight - height[right];
            }
        }

        return ans;
    }
}