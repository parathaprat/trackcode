class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] in = intervals[0];

        List<int[]> result = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){

            if(in[1] < intervals[i][0]){
                result.add(in);
                in = intervals[i];
            }
            else{
                in[1] = Math.max(in[1], intervals[i][1]);
            }
        }

        result.add(in);
        return result.toArray(new int[result.size()][2]);
        
    }
}