class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        //binary search eating speed, from 1 to max in pile

        int k = 0;
        
        for(int pile : piles){
            if(pile > k) k = pile;
        }

        int l = 1;
        int r = k;
        

        while(l <= r){

            //mid is our candidate speed
            int mid = l + (r - l)/2;

            //test if mid is a valid solution, compute hours and check with h
            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double)pile/mid);
            }

            if(hours <= h){
                k = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return k;
    }
}