class Solution {

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {

        boolean[][] visit = new boolean[rooms.length][rooms[0].length];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){

                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int dist = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                int[] room = q.poll();
                visit[room[0]][room[1]] = true;

                for(int[] dir : directions){

                    int nr = room[0] + dir[0];
                    int nc = room[1] + dir[1];

                    if(nr >= 0 && nr < rooms.length && nc >= 0 && nc < rooms[0].length && rooms[nr][nc] == Integer.MAX_VALUE && !visit[nr][nc]){

                        rooms[nr][nc] = dist;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            dist++;
        }
        
    }
}