class MedianFinder {

    //1st half: maxHeap
    //2nd half: minHeap

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        
    }
    
    public void addNum(int num) {

        maxHeap.offer(num);

        while(maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }

        while(minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {

        double ans = 0;

        if(maxHeap.size() == minHeap.size()) ans = (double)(maxHeap.peek() + minHeap.peek())/2;
        else if(maxHeap.size() > minHeap.size()) ans = (double)maxHeap.peek();
        else ans = minHeap.peek();

        return (double)ans;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */