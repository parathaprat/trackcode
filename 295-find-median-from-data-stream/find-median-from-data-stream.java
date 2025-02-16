class MedianFinder {

    //2 heaps needed
    
    //maxHeap -> first half
    //minHeap -> 2nd half
    
    //keep balancing elements, until they are about the same length

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);

    }
    
    public void addNum(int num) {

        //add to 1st heap, then balance
        maxHeap.add(num);

        //if first half is larger || first half got bigger elements than 2nd half, 2nd.add(1st)
        if(maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) minHeap.add(maxHeap.poll());

        //if 2nd half is larger, 1st half.add(2nd half)
        if(minHeap.size() - maxHeap.size() > 1) maxHeap.add(minHeap.poll());

    }
    
    public double findMedian() {

        double ans = 0;
        
        if(maxHeap.size() == minHeap.size()) ans = (double)(maxHeap.peek() + minHeap.peek()) / 2;
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