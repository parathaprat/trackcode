class Solution {

    //declare global set
    Set<Integer> set = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        
        //define dp array with size = 30 + max day number
        int lastDay = days[days.length - 1] + 30;
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        //add all days to set
        for(int day : days){
            set.add(day);
        }

        return recur(dp, days, costs, days[0]);
    }

    int recur(int[] dp, int[] days, int[] costs, int curr){

        //if day is greater, return 0 cost (target achieved)
        if(curr > days[days.length - 1]){
            dp[curr] = 0;
            return 0;
        }

        if(dp[curr] != -1){
            return dp[curr];
        }

        //if curr is not in days, move to next day
        if(!set.contains(curr)){
            dp[curr] = recur(dp, days, costs, curr + 1);
            return dp[curr];
        }

        //for a day contained within days, count cost for all 3 tickets and recursively return min
        int oneDay = costs[0] + recur(dp, days, costs, curr + 1);
        int sevenDay = costs[1] + recur(dp, days, costs, curr + 7);
        int thirtyDay = costs[2] + recur(dp, days, costs, curr + 30);

        dp[curr] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        return dp[curr];
    }
}