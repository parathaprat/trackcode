class Solution {

    class tuple{

        int num;
        int pow;

        tuple(int num, int pow){
            this.num = num;
            this.pow = pow;
        }
    }

    //num -> pow
    Map<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        
        for(int i = lo; i <= hi; i++){

            map.put(i, getPow(i));

        }

        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> a.pow != b.pow ? b.pow - a.pow : b.num - a.num);

        for(int i = lo; i <= hi; i++){

            pq.add(new tuple(i, map.get(i)));

            if(pq.size() > k) pq.poll();

        }

        return pq.poll().num;
    }

    private int getPow(int num){

        if(num == 1) return 1;

        if(map.containsKey(num)) return map.get(num);

        int pow = num % 2 == 0 ? 1 + getPow(num / 2) : 1 + getPow(3 * num + 1);

        return pow;
    }
}