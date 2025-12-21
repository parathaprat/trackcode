class Solution {

    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = i;
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            if(!union(u, v)){
                return e;
            }
        }

        return new int[0];
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

        if(rank[pv] > rank[pu]){
            int temp = pv;
            pv = pu;
            pu = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}