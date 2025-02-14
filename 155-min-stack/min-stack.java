class MinStack {

    class tuple{

        int num;
        int min;

        tuple(int num, int min){
            this.num = num;
            this.min = min;
        }

    }

    Stack<tuple> minStack;

    public MinStack() {
        
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        
        //if st is emopty -> {val, val}
        //if not -> {val, min{st.peek.min, val}}

        if(minStack.isEmpty()) minStack.push(new tuple(val, val));
        else minStack.push(new tuple(val, Math.min(val, minStack.peek().min)));
    }
    
    public void pop() {
        
        if(!minStack.isEmpty()) minStack.pop();

    }
    
    public int top() {

        return minStack.peek().num;
        
    }
    
    public int getMin() {
        
        return minStack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */