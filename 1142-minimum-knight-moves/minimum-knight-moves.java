class Solution {

    int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public int minKnightMoves(int x, int y) {

        //quadrant reduction to 1st quad
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new int[]{0, 0});
        visited.add("0,0");

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                int[] rc = q.poll();
                int row = rc[0];
                int col = rc[1];

                if(row == x && col == y) return steps;

                for(int[] dir : directions){

                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr < -2 || nr > x + 2 || nc < -2 || nc > y + 2) continue; //bounding 

                    String key = nr + "," + nc;

                    if(!visited.contains(key)){
                        q.add(new int[]{nr, nc});
                        visited.add(key);
                    }
                }
            }
            steps++;
        }

        return -1;   
    }
}