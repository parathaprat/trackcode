class Solution {
    public double myPow(double x, int n) {

        if(n == 0) return 1;
        if(x == 0) return 0;
        
        //to stop integer overflow
        double res = getAns(x, Math.abs((long) n));

        if(n >= 0) return res;
        return 1/res;

    }

    private double getAns(double x, long n){

        if(n == 0) return 1;

        double half = getAns(x, n/2);

        if(n % 2 == 1){
            return x * half * half;
        }

        return half * half;

    }
}