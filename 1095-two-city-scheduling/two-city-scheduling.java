class Solution {
    public int twoCitySchedCost(int[][] costs) {

        //sort by costA - costB
        //1st half fly to A, 2nd half fly to B

        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int sum = 0;

        for(int i = 0; i < costs.length; i++){

            if(i < costs.length/2) sum += costs[i][0];
            else sum += costs[i][1];
        }

        return sum;


    }
}