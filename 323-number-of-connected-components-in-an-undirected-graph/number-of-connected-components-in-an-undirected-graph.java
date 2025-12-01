class Solution {

    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int comp = n;

        for(int[] edge : edges){

            if(union(edge[0], edge[1])) comp--;
        }

        return comp;
    }

    private boolean union(int u, int v){

        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false; //alr in the same component

        if(rank[pu] < rank[pv]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }

    private int find(int node){

        int cur = node;

        while(parent[cur] != cur){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }

        return cur;
    }
}