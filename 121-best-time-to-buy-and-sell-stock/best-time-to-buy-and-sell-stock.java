class Solution {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int prof = 0;

        for(int price : prices){

            if(price < min) min = price;
            prof = Math.max(prof, price - min);
        }
        
        return prof;
    }
}