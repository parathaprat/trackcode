class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        //BFS bellman ford
        //Maintian a prices and temp array 
        //assign temp to prices at each iteration 

        int[] prices = new int[n];

        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;

        for(int i = 0; i <= k; i++){

            int[] temPrices = Arrays.copyOf(prices, n);

            for(int[] flight : flights){

                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                if(prices[source] == Integer.MAX_VALUE) continue;

                if(prices[source] + price < temPrices[destination]){
                    temPrices[destination] = prices[source] + price;
                }
            }

            prices = temPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];


    }
}