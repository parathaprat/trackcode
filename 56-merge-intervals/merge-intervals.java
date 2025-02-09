class Solution {
    public int[][] merge(int[][] intervals) {

        //base
        if(intervals.length <= 1){
            return intervals;
        }

        //arrange intervals by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 1; 

        int[] in = intervals[0];

        List<int[]> result = new ArrayList<>();

        while(i < intervals.length){

            //if ending of in < starting of next interval -> disjoint
            if(in[1] < intervals[i][0]){

                result.add(in);
                in = intervals[i];

            }

            else{

                in[1] = Math.max(in[1], intervals[i][1]);
                
            }

            i++;
        }

        result.add(in);

        return result.toArray(new int[result.size()][2]);
        
    }
}