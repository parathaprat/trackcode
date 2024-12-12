class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        long sum = 0;

        //make a max heap to sort gifts
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        //find sum and add to maxHeap
        for(int giftPile : gifts){
            sum += giftPile;
            pq.add(giftPile);
        }

        //go through k 
        while(k-- > 0){

            //take out largest number and remove from sum
            int largest = pq.poll();
            sum -= largest;

            //leave floor of sqrt; add to pile and total sum
            int sqrt = (int)Math.sqrt(largest);
            pq.add(sqrt);

            sum += sqrt;
        }

        return sum;
    }
}