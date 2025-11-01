class Solution {

    int[] parent;
    int[] rank;

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = i;
        }

        int prov = n;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){

                if(isConnected[i][j] == 1){
                    if(union(i, j)) prov--;
                }
            }
        }

        return prov;
    }

    private int find(int node){

        int cur = node;

        while(cur != parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }

        return cur;
    }

    private boolean union(int u, int v){

        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(rank[pu] < rank[pv]){
            int temp = pv;
            pv = pu;
            pu = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}