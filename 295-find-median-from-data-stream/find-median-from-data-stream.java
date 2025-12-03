class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
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

        if((minHeap.size() + maxHeap.size()) % 2 == 0){
            return (double)(minHeap.peek() + maxHeap.peek())/2.0;
        }
        else{
            if(minHeap.size() > maxHeap.size()) return minHeap.peek();
            else return maxHeap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */