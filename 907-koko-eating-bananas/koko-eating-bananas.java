class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        //binary search speed, calculate hours and compare with h
        //assume max speed = max(piles) first

        int k = 0;

        for(int pile : piles){
            if(k < pile) k = pile;
        }

        int l = 1;
        int r = k;

        while(l <= r){

            int m = l + (r - l)/2;

            //calaculate hours to eat with speed m
            int hours = 0;
            for(int pile : piles){
                hours+= Math.ceil((double)pile/m);
            }

            //<= since lesser is also a valid/better ans and we reduce search space to find better
            if(hours <= h){
                k = m;
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }

        return k; 
    }
}