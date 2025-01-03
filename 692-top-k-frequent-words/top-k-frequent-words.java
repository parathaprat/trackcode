class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> freq = new HashMap<>();

        //populating hashmap [word, frequency]
        for(int i = 0; i < words.length; i++){

            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);

        }

        List<String> result = new ArrayList(freq.keySet());

        //main logic
        Collections.sort(result, (w1, w2) -> 
        
        //if freq are equal, sort lexicographically using words, otherwise most freq first
        freq.get(w1).equals(freq.get(w2)) ? w1.compareTo(w2) : freq.get(w2) - freq.get(w1));

        //return sublist (0,k)
        return result.subList(0, k);
    }
}