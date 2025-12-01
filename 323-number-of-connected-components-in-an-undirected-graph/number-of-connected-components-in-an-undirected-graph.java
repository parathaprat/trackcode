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

        //decrement comp count for every valid union
        for(int[] edge : edges){
            if(union(edge[0], edge[1])){
                comp--;
            }
        }

        return comp;
    }

    private boolean union(int u, int v){

        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false; //alr connected if parents are equal

        if(rank[pu] < rank[pv]){ //swap since we will set pv's parent as pu
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv]; //add the rank/size of pv componenet to pu

        return true;
    }

    //find parent of a node
    private int find(int node){

        int cur = node;

        while(cur != parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }

        return cur;
    }
}