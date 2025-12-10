class Solution {
    public int maxProfit(int[] prices) {

        int low = Integer.MAX_VALUE;
        int prof = Integer.MIN_VALUE;

        for(int num : prices){

            if(low > num) low = num;
            prof = Math.max(prof, num - low);
        }

        return prof;
        
    }
}