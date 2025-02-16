class Solution {
    public int orangesRotting(int[][] grid) {
        
        //brute force bfs

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 2) q.add(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;

            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int time = 0;
        while(!q.isEmpty() && fresh != 0){

            int level = q.size();

            for(int i = 0; i < level; i++){

                int[] rot = q.poll();

                for(int[] dir : directions){

                    int nr = rot[0] + dir[0];
                    int nc = rot[1] + dir[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});

                    }
                }


            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}