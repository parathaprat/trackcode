class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int start_pos = 0;

        for(int i = 0; i < n; i++){

            int gain = gas[i] - cost[i];
            total_tank += gain;
            curr_tank += gain;

            if(curr_tank < 0){
                curr_tank = 0;
                start_pos = i + 1;
            }
        }

        if(total_tank >= 0){
            return start_pos;
        }

        return -1;
    }
}