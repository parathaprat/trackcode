class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        

        //value[i] + value[j] + i - j == (value[i] + i) + (value[j] - j) // we will maximize both these components

        //represents 1st component
        int maxi = values[0] + 0;
        int ans = -1;

        for(int i = 1; i < values.length; i++){

            //adding both components, maximizing 2nd component 
            ans = Math.max(ans, maxi + values[i] - i);

            //maximizing first component
            maxi = Math.max(maxi, values[i] + i);

        }

        return ans;
    }
}