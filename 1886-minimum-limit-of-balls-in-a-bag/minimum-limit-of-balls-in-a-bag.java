class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1;
        int right = 0;
        
        //right boundry for binary search is highest number
        for(int num : nums){
            right = Math.max(right, num);
        }

        //provisional ans is highest number (rihgt boundry)
        int ans = right;

        while(left <= right){

            int mid = left + (right - left)/2;

            //mid = max balls in a bag
            if(isPossible(mid, nums, maxOperations)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }

    //binary searching for each max balls in a bag
    public boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations){

        int totalOperations = 0;

        for(int num : nums){

            //main logic -> each bag divided into parts; ceil to account for nums with remainders; -1 since x parts is x - 1 cuts
            int operations = (int)Math.ceil((double)num/ maxBallsInBag) - 1;
            totalOperations += operations;

        }

        //if operations for a particular max balls is less than max, return true 
        if(totalOperations <= maxOperations){
            return true;
        }

        return false;
    }
}