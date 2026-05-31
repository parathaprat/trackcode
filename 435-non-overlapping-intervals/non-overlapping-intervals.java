class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int[] in = intervals[0];
        int res = 0;

        for(int i = 1; i < intervals.length; i++){

            if(in[1] > intervals[i][0]){
                res++;
                continue;
            }

            in = intervals[i];
        }

        return res;
        
    }
}