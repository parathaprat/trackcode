class Solution {
    public int maxProfit(int[] prices) {
        
        int low = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){

            if(prices[i] < low) low = prices[i];
            if(prices[i] - low > maxProf) maxProf = prices[i] - low;
        }

        return maxProf;
    }
}