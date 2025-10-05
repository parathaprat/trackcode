class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] in = intervals[0];

        List<int[]> finalAns = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++){

            if(in[1] < intervals[i][0]){
                finalAns.add(in);
                in = intervals[i];
            }
            else{
                in[1] = Math.max(in[1], intervals[i][1]);
            }
        }

        finalAns.add(in);

        return finalAns.toArray(new int[finalAns.size()][2]);


        
    }
}