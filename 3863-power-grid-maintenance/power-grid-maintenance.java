//DSU, minheap, lazy deletion

class Solution {

    static class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent = new int[n + 1];
            size = new int[n + 1];

            for(int i = 0; i <= n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void unite(int a, int b){
            a = find(a);
            b = find(b);

            if(a == b) return;

            if(size[a] < size[b]){
                int temp = a;
                a = b;
                b = temp;
            }

            parent[b] = a;
            size[a] += size[b];
        }

    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        DSU dsu = new DSU(c);

        for(int[] e : connections){
            int a = e[0];
            int b = e[1];

            dsu.unite(a, b);
        }

        Map<Integer, PriorityQueue<Integer>> componentToMinHeap = new HashMap<>();

        for(int computer = 1; computer <= c; computer++){

            int leader = dsu.find(computer);
            componentToMinHeap.computeIfAbsent(leader, k -> new PriorityQueue<>()).offer(computer);

        }

        boolean[] isOffline = new boolean[c + 1];

        List<Integer> answers = new ArrayList<>();

        for(int[] q : queries){
            int type = q[0];
            int x = q[1];

            if(type == 2){
                isOffline[x] = true;
                continue;
            }

            if(!isOffline[x]){
                answers.add(x);
                continue;
            }

            int leader = dsu.find(x);
            PriorityQueue<Integer> heap = componentToMinHeap.get(leader);

            if(heap == null){
                answers.add(-1);
                continue;
            }

            while(!heap.isEmpty() && isOffline[heap.peek()]){
                heap.poll();
            }

            if(heap.isEmpty()){
                answers.add(-1);
            }
            else{
                answers.add(heap.peek());
            }
        }

        int[] result = new int[answers.size()];
        for(int i = 0; i < answers.size(); i++){
            result[i] = answers.get(i);
        }

        return result;
    }
}