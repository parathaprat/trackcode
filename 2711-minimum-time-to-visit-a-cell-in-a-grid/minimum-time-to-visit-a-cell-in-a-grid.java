class Solution {

    //define a class to hold values
    class structure{
        int time;
        int row;
        int col;

        structure(int time, int row, int col){
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumTime(int[][] grid) {

        //solve this problem using Dijkstras (BFS using PQ)

        if(Math.min(grid[1][0], grid[0][1]) > 1){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        //define minheap sorted by block access time
        Queue<structure> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new structure(0, 0, 0));

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        //start BFS
        while(!pq.isEmpty()){
            structure loc = pq.poll();
            int rowLoc = loc.row;
            int colLoc = loc.col;
            int timeLoc = loc.time;

            if(rowLoc == rows - 1 && colLoc == cols - 1){
                return timeLoc;
            }

            for(int[] dir : dirs){
                int nextRow = rowLoc + dir[0];
                int nextCol = colLoc + dir[1];

                if(nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || visited[nextRow][nextCol]){
                    continue;
                }

                //main logic of code
                int wait = 0;
                //neetcode explanation; for every differce that is 0, wait goes to 1
                if(Math.abs(grid[nextRow][nextCol] - timeLoc) % 2 == 0){
                    wait = 1;
                }

                int nextTime = Math.max(grid[nextRow][nextCol] + wait, timeLoc + 1);

                pq.add(new structure(nextTime, nextRow, nextCol));
                visited[nextRow][nextCol] = true;
            }

        }

    return -1;

        
    }
}