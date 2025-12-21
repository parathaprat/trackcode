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

        int count = n;

        for(int[] e : edges){
            if(union(e[0], e[1])) count--;
        }

        return count;
    }

    private boolean union(int u, int v){

        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(pv > pu){
            int temp = pv;
            pv = pu;
            pu = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv]; 
        return true;
    }

    private int find(int node){

        int cur = node;

        while(cur != parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }

        return cur;
    }
}