class MedianFinder {

    //maxHeap for smaller half 
    //minHeap for larger half

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> bigHeap; 

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        bigHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        
        smallHeap.add(num);

        if(smallHeap.size() - bigHeap.size() > 1 || !bigHeap.isEmpty() && smallHeap.peek() > bigHeap.peek()){

            bigHeap.add(smallHeap.poll());

        }
        if(bigHeap.size() - smallHeap.size() > 1){
            smallHeap.add(bigHeap.poll());
        }
    }
    
    public double findMedian() {
        
        if(bigHeap.size() == smallHeap.size()){
            return (double)(bigHeap.peek() + smallHeap.peek()) / 2;
        }
        else if(smallHeap.size() > bigHeap.size()) return smallHeap.peek();
        else{
            return bigHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */