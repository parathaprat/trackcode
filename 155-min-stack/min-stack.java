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

        int min = val;

        if(!st.isEmpty()){
            min = Math.min(val, st.peek().min);
        }

        st.push(new tuple(val, min));
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