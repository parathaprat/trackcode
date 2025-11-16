class Solution {

    class tuple{

        int num;
        int pow;

        tuple(int num, int pow){
            this.num = num;
            this.pow = pow;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {

        PriorityQueue<tuple> maxHeap = new PriorityQueue<>((a, b) -> a.pow == b.pow ? b.num - a.num : b.pow - a.pow);

        for(int i = lo; i <= hi; i++){

            maxHeap.add(new tuple(i, getPow(i)));

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        return maxHeap.poll().num;
        
    }

    private int getPow(int i){

        if(i == 1) return 0;

        if(map.containsKey(i)) return map.get(i);

        int pow = 1 + (i % 2 == 0 ? getPow(i / 2) : getPow(3 * i + 1));

        map.put(i, pow);

        return pow;

    }
}