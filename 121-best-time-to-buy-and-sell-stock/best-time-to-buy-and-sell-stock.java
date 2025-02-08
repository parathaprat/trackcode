class Solution {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProf = 0;
        
        for(int i = 0; i < prices.length; i++){

            if(prices[i] < min) min = prices[i];

            if(min != prices[i]){

                maxProf = Math.max(prices[i] - min, maxProf);
            }

        }

        return maxProf;
    }
}