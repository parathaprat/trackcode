class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //make frequency array for each str
        //.toString() and add as key to map; word to list of that key
        //add that to list<list<>>

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            int[] freq = new int[26];

            for(char c : str.toCharArray()){

                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }
}