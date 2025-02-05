class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //sort coins first
        Arrays.sort(coins);

        //dp[] = minimum number of coins to make an amount
        int[] dp = new int[amount + 1];

        //fill dp array with a theoretical infinite (amount will always take less than amount coins)
        Arrays.fill(dp, amount + 1);

        //0 coins to make amount 0
        dp[0] = 0;

        //loop through each amount and for each amount loop through each denomination
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){

                //if denomination is lower than amount
                if(coins[j] <= i){

                    //assign min coins to min(previous val, coin + val[amount - caoin]) 
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);

                }
                else{
                    break;
                }

            }
        }

        //return final ans if lower than amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}