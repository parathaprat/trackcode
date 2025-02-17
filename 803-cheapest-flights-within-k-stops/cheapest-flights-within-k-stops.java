class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        //bellman ford algorithm 
        //maintian a prices array and a temp prices array
        //at each iteration copy the temp prices to prices/
        //BFS at its core

        //Initialise prices array and set it to infinity
        int[] prices = new int[n];
        Arrays.fill (prices, Integer.MAX_VALUE);

        //since cost to get from src -> src is 0
        prices[src] = 0;

        //iterate k + 1 times 
        for(int i = 0; i <= k; i++){

            //create temp prices to make changes on
            int[] temPrices = Arrays.copyOf(prices, n);

            for(int[] flight : flights){

                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                //if the source city itself is not reachable, skip
                if(prices[source] == Integer.MAX_VALUE) continue;

                //if source is reachable, check if updated cost < current cost, and if it is, update in temp
                if(prices[source] + price < temPrices[destination]){

                    temPrices[destination] = prices[source] + price;
                }
            }

            prices = temPrices;
        }

        //return -1 if price to get to dest is infinity
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}