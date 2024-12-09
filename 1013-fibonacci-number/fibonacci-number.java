class Solution {
    public int fib(int n) {

        //create base cases
        if(n == 0) return 0;
        if(n == 1) return 1;

        //create dp array of size n + 1
        int[] fib = new int[n + 1];

        //1st and 2nd values already known
        fib[0] = 0;
        fib[1] = 1;

        //calculate rest of the array
        for(int i = 2; i <= n; i++){
            fib[i] = fib[i - 1] + fib[i - 2]; 
        }

        return fib[n];
    }
}