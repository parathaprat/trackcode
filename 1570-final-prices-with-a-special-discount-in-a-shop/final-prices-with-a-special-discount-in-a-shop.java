class Solution {
    public int[] finalPrices(int[] prices) {
        

        //using monotonic stack increasing order

        Stack<Integer> stack = new Stack<>();

        int n = prices.length;

        //go through prices from the end
        for(int i = n - 1; i >= 0; i--){

            //for every element that is < element in stack, pop
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            } 

            int val = prices[i];

            //if elements exist in stack (element > element in stack) update prices[i]
            if(!stack.isEmpty()){
                prices[i] -= stack.peek();
            }

            //push said element to stack
            stack.push(val);
        }

        return prices;
    }
}