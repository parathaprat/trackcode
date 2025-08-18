class Solution {
    public int maxProfit(int[] prices) {
        
        //track min, keep updating prof

        int min = Integer.MAX_VALUE;
        int prof = 0;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < min) min = prices[i];

            prof = Math.max(prof, prices[i] - min);
        }

        return prof;
    }
}