class Solution {
    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int ans = 0;

        while(left <= right){

            int mid = left + (right - left) / 2;
            long sq = (long)mid*mid;

            if(sq <= x){
                left = mid + 1;
                ans = mid;
            }
            else{
                right = mid - 1;
            }
        }

        return ans;
    }
}