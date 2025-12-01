class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {

        maxHeap.add(num);

        if(maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
        }

        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {

        double ans = 0;

        if(maxHeap.size() == minHeap.size()) ans = (double)(maxHeap.peek() + minHeap.peek()) / 2;
        else if(minHeap.size() > maxHeap.size()) ans = minHeap.peek();
        else ans = maxHeap.peek();

        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */