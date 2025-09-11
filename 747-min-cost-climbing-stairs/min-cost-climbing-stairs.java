class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] costReach = new int[cost.length];

        costReach[0] = cost[0];
        costReach[1] = cost[1];

        for(int i = 2; i < cost.length; i++){

            costReach[i] = Math.min(cost[i] + costReach[i - 1], cost[i] + costReach[i - 2]);

        }

        return Math.min(costReach[costReach.length - 1], costReach[costReach.length - 2]);
    }
}