class Solution {
    public int maxProfit(int[] prices) {

        int prof = 0;
        int buy = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < buy) buy = prices[i];
            prof = Math.max(prof, prices[i] - buy);
        }

        return prof;
        
    }
}