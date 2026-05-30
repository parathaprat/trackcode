class Solution {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;

        for(int price : prices){

            if(price < min) min = price;
            if(price - min > maxProf) maxProf = Math.max(maxProf, price - min);
        }

        return maxProf;
        
    }
}