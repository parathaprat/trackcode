class Solution {

    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] e : edges){

            if(!union(e[0], e[1])) return e;
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