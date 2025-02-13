class Solution {
    public String reorganizeString(String s) {
        
        //Freq map
        //maxHeap -> arrange freqs

        Map<Character, Integer> map = new HashMap<>();

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        //populating our map
        for(char c : s.toCharArray()){

            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(maxHeap.size() >= 2){

            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();

            sb.append(c1);
            sb.append(c2);

            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);

            if(map.get(c1) > 0) maxHeap.add(c1);
            if(map.get(c2) > 0) maxHeap.add(c2);

        }

        if(!maxHeap.isEmpty()){

            char c = maxHeap.poll();

            if(map.get(c) > 1){
                sb.setLength(0);
            }
            else{
                sb.append(c);
            }

        }

        return sb.toString();



        

    }
}