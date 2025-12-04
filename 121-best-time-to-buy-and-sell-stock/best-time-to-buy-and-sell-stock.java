class Solution {
    public int maxProfit(int[] prices) {

        int low = Integer.MAX_VALUE;
        int prof = 0;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < low) low = prices[i];
            prof = Math.max(prices[i] - low, prof);

        }

        return prof;
        
    }
}