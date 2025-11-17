class Solution {
    public int findTheWinner(int n, int k) {

        LinkedList<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        int lost = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < k - 1; j++){
                q.add(q.poll());
            }

            lost = q.poll();
        }

        return lost; 
    }
}