class MinStack {

    class tuple{

        int num;
        int min;

        tuple(int num, int min){
            this.num = num;
            this.min = min;
        }
    }

    Stack<tuple> st;

    public MinStack() {

        st = new Stack<>();
        
    }
    
    public void push(int val) {

        if(st.isEmpty()) st.push(new tuple(val, val));
        else st.push(new tuple(val, Math.min(val, getMin())));
        
    }
    
    public void pop() {

        if(!st.isEmpty()) st.pop();
        
    }
    
    public int top() {

        return st.peek().num;
        
    }
    
    public int getMin() {

        return st.peek().min;
        
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