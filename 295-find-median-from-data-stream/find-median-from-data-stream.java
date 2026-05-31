class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b , a));
    }
    
    public void addNum(int num) {
        
        maxHeap.add(num);

        if(maxHeap.size() > minHeap.size() || !minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
            minHeap.add(maxHeap.poll());
        }

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {

        if(minHeap.size() == maxHeap.size()){
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