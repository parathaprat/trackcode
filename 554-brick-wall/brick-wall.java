class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> map = new HashMap<>(); //position -> no of gaps

        int max = 0;

        for(List<Integer> row : wall){

            int gapPos = 0;

            for(int i = 0; i < row.size() - 1; i++){
                gapPos += row.get(i);

                map.put(gapPos, map.getOrDefault(gapPos, 0) + 1);
                max = Math.max(max, map.get(gapPos));
            }
        }

        return wall.size() - max;

        
    }
}