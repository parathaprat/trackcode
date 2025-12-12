class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int k = 0;

        for(int pile : piles){
            if(k < pile) k = pile;
        }

        int l = 1;
        int r = k;

        while(l <= r){

            int m = l + (r - l)/2;

            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double)pile/m);
            }

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