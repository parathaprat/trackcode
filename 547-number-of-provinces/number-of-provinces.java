class Solution {
    public int findCircleNum(int[][] isConnected) {

        //BFS imp
        
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < isConnected.length; i++){

            if(!visited.contains(i)){

                q.add(i);

                while(!q.isEmpty()){

                    int node = q.poll();
                    visited.add(node);

                    for(int j = 0; j < isConnected[node].length; j++){

                        if(isConnected[node][j] == 1 && !visited.contains(j)){
                            visited.add(j);
                            q.add(j);
                        }
                    }

                }

                provinces++;
            }
        }

        return provinces;  
    }
}