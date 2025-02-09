class Solution {
    public String reorganizeString(String s) {
        
        //Map and maxHeap appraoch

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){

            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        //mapHeap to sort added chars in decending order of thier frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        //now we have all chars sorted by their freq in our maxHeap 

        StringBuilder sb = new StringBuilder();

        while(maxHeap.size() >= 2){

            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();

            sb.append(c1);
            sb.append(c2);

            //update frequencies of chars
            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);

            //add them back if freqs are > 0
            if(map.get(c1) > 0) maxHeap.add(c1);
            if(map.get(c2) > 0) maxHeap.add(c2);

        }

        //to process that one remaining char
        if(maxHeap.size() != 0){

            char ch = maxHeap.poll();
            if(map.get(ch) > 1) return "";

            sb.append(ch);
        }

        return sb.toString();

    }
}