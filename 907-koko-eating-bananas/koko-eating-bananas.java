class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        //the idea -> binary search No of bananas per four from 0 -> max(pile)

        int k = 0;

        for(int num : piles){

            if(num > k) k = num;

        }

        int l = 1;
        int r = k;

        int result = k;

        while(l <= r){

            int mid = l + (r - l) / 2;

            int hours = 0;

            for(int pile : piles){

                hours += Math.ceil((double)pile/mid);

            }

            if(hours <= h){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }

           
        }

        return result;
    }
}