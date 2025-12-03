class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int[] in = intervals[0];
        int res = 0;

        int i = 1;

        while(i < intervals.length){

            if(in[1] > intervals[i][0]){
                res++;
                i++;
                continue;
            }

            in = intervals[i];
            
            i++;
        }

        return res;
    }
}