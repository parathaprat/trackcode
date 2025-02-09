class Solution {
    public String reorganizeString(String s) {
        
        //frequency map
        Map<Character, Integer> map = new HashMap<>();

        //maxHeap to sort by freq
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        //stringbuilder
        StringBuilder result = new StringBuilder();

        //fill map and heap

        for(char c : s.toCharArray()){

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        maxHeap.addAll(map.keySet());

        //now we have a heap with letter sorted by freq
        while(maxHeap.size() >= 2){
            
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();

            result.append(c1);
            result.append(c2);

            if(map.get(c1) != 0){
                map.put(c1, map.get(c1) - 1);

                if(map.get(c1) != 0) maxHeap.add(c1);
            }

            if(map.get(c2) != 0){
                map.put(c2, map.get(c2) - 1);

                if(map.get(c2) != 0) maxHeap.add(c2);
            } 

        }

        if(!maxHeap.isEmpty()){

            if(maxHeap.size() != 1){
                return " ";
            } 
            else{
                char c = maxHeap.poll();
                if(map.get(c) > 1) return "";
                result.append(c);
            }
        }



        return result.toString();



    }
}