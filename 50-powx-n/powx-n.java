class Solution {
    public double myPow(double x, int n) {
        
        //recursion -> x^10 = x^5 * x^5

        if(n == 0) return 1;
        if(x == 0) return 0;

        double ans = getAns(x, Math.abs((long) n));

        return n < 0 ? 1/ans : ans;
    }

    private double getAns(double x, long n){

        if(n == 1) return x;

        double half = getAns(x, n/2);

        return n%2 == 0 ? half * half : half * x * half;
    }
}