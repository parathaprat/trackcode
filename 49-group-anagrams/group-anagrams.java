class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //solution:
        //map<freqArray to String, word>
        //return map as arrayList

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){

            int[] freq = new int[26];

            for(char ch : strs[i].toCharArray()){
                freq[ch - 'a']++;
            }

            String key = Arrays.toString(freq);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(strs[i]);

        }

        return new ArrayList<>(map.values());
    }
}