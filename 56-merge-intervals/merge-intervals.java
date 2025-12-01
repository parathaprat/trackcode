class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int[] in = intervals[0];

        for(int i = 1; i < intervals.length; i++){

            if(in[1] >= intervals[i][0]){
                // in[0] = Math.min(in[0], intervals[i][0]);
                in[1] = Math.max(in[1], intervals[i][1]); 
            }
            else{
                res.add(in);
                in = intervals[i];
            }
        }

        res.add(in); 

        return res.toArray(new int[res.size()][2]);
    }
}