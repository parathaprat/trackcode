class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        //non overlapping: curr[end] < new[start]
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //overlapping: curr[start] <= new[end]
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        //rest non overlapping
        while(i < n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
        
    }
}