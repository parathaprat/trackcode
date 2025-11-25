class Solution {
    public int maxProfit(int[] prices) {

        int prof = 0;
        int low = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < low) low = prices[i];

            prof = Math.max(prof, prices[i] - low);
        }

        return prof;
        
    }
}