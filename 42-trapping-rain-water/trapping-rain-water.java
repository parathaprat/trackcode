class Solution {
    public int trap(int[] height) {
        
        if(height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;

        int finalAns = 0;

        int leftMax = height[left];
        int rightMax = height[right];

        //smaller boundry is determining factor, so move the pointer with the smaller max
        while(left < right){

            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                finalAns += leftMax - height[left];
            }

            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                finalAns += rightMax - height[right];
            }
        }

        return finalAns;
    }
}