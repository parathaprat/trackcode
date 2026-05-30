class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int k = 0;

        for(int pile : piles){
            if(k < pile) k = pile;
        }

        int left = 1;
        int right = k;

        while(left <= right){

            int mid = right - (right - left)/2;

            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double)pile/mid);
            }

            if(hours <= h){
                k = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return k;
    }
}