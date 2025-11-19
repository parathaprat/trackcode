class AutocompleteSystem {

    Map<String, Integer> freq;
    StringBuilder current;

    public AutocompleteSystem(String[] sentences, int[] times) {
        
        freq = new HashMap<>();
        current = new StringBuilder();

        ///store all frequencies in a map
        for(int i = 0; i < sentences.length; i++){
            freq.put(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {

        //if # excountered, add to map, update freq, reset sb, return empty list
        if(c == '#'){
            String sentence = current.toString();
            freq.put(sentence, freq.getOrDefault(sentence, 0) + 1);
            current = new StringBuilder();
            return new ArrayList<>();
        }

        current.append(c);
        String prefix = current.toString();

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {

            if(!freq.get(a).equals(freq.get(b))) return freq.get(a) - freq.get(b);
            return b.compareTo(a);

        });

        for(String sentence : freq.keySet()){

            if(sentence.startsWith(prefix)){
                pq.offer(sentence);

                if(pq.size() > 3) pq.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while(!pq.isEmpty()){
            result.add(0, pq.poll());
        }

        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */