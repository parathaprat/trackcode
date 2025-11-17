class Solution {
    public int findTheWinner(int n, int k) {

        LinkedList<Integer> participants = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            participants.add(i);
        }

        int lost = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < k - 1; j++){
                participants.add(participants.poll());
            }

            lost = participants.poll();
        }

        return lost;
        
    }
}