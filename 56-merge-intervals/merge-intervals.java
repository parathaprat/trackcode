class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] in = intervals[0];

        for(int i = 1; i < intervals.length; i++){

            if(in[1] < intervals[i][0]){
                res.add(in);
                in = intervals[i];
            }
            if(in[0] <= intervals[i][1]){
                in[0] = Math.min(in[0], intervals[i][0]);
                in[1] = Math.max(in[1], intervals[i][1]);
            }
        }

        res.add(in);

        int[][] ans = new int[res.size()][2];

        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}