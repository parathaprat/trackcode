class Solution {

    //create a tuple of each num and its power
    //store k tuples in a max Heap of size k;
    //return top of stack as the ans 

    class tuple{

        int num;
        int pow;

        tuple(int num, int pow){
            this.num = num;
            this.pow = pow;
        }
    }

    //map storing num -> pow to avoid duplicates
    Map<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {

        PriorityQueue<tuple> maxHeap = new PriorityQueue<>((a, b) -> b.pow != a.pow ? b.pow - a.pow : b.num - a.num);

        for(int i = lo; i <= hi; i++){

            maxHeap.add(new tuple(i, getPow(i)));

            if(maxHeap.size() > k) maxHeap.poll();
        }

        return maxHeap.poll().num;
    }

    private int getPow(int num){

        if(num == 1) return 0;

        if(map.containsKey(num)) return map.get(num);

        int pow = 1 + (num % 2 == 0 ? getPow(num/2) : getPow(3 * num + 1));

        map.put(num, pow);

        return pow;


    }
}