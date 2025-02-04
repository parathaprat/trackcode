class Solution {
    public int maxProfit(int[] prices) {
        
        //2 pointer method

        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < min_val) min_val = prices[i];

            if(max_profit < prices[i] - min_val) max_profit = prices[i] - min_val;
        }

        return max_profit;
    }
}