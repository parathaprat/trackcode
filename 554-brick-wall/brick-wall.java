class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        //map position -> number of gaps
        //add line at the position with max gaps, crossing the least leastBricks

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxGaps = 0;

        for(List<Integer> row : wall){

            int gap = 0;

            for(int i = 0; i < row.size() - 1; i++){
                gap += row.get(i);
                map.put(gap, map.getOrDefault(gap, 0) + 1);
                maxGaps = Math.max(maxGaps, map.get(gap));
            }

        }

        return wall.size() - maxGaps;
        
    }
}