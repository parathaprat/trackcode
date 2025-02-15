class Solution {
    public double myPow(double x, int n) {

        if(n == 0) return 1;
        if(x == 0) return 0;

        double res = getAns(x, Math.abs((long)n));

        return n > 0 ? res : 1/res;
        
    }

    private double getAns(double x, long n){

        if(n == 0) return 1;

        double half = getAns(x, n/2);

        return n%2 == 1 ? half * half * x : half * half;
    }
}