class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int steps = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                int[] cur = q.poll();

                if(cur[0] == grid.length - 1 && cur[1] == grid.length - 1) return steps;
                
                for(int[] dir : directions){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || visited[nr][nc] || grid[nr][nc] == 1) continue;

                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                    
                }
            }

            steps++;
        }

        return -1;


    }
}