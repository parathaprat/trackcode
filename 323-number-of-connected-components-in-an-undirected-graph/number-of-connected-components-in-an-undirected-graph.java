class Solution {

    //DSU: union: connect components
    //find: find parents

    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int count = n;

        for(int[] e : edges){

            if(union(e[0], e[1])){
                count--;
            }
        }

        return count;
    }

    private boolean union(int u, int v){

        int pv = find(v);
        int pu = find(u);

        if(pv == pu) return false;

        if(rank[pu] > rank[pv]){
            int temp = pv;
            pv = pu;
            pu = temp;
        }

        parent[pu] = pv;

        rank[pv] += rank[pu];
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