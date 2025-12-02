class Solution {
    public int maxProfit(int[] prices) {

        //profit = buy low, sell high

        int low = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int num : prices){
            if(num < low) low = num;
            profit = Math.max(num - low, profit);
        }

        return profit;
        
    }
}