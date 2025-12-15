class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        maxHeap.add(num);

        if(maxHeap.size() > minHeap.size() || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
        }

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek())/2.0;
        }
        else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else return minHeap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */