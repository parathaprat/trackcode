class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        //BFS imp

        Set<Integer> set = new HashSet<>();
        int prov = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < isConnected.length; i++){

            if(!set.contains(i)){

                q.add(i);

                while(!q.isEmpty()){

                    int node = q.poll();
                    set.add(node);

                    for(int j = 0; j < isConnected[node].length; j++){

                        if(isConnected[node][j] == 1 && !set.contains(j)){
                            q.add(j);
                        }
                    }
                }

                prov++;
            }

        }

        return prov;
    }
}