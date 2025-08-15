class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //Approach: freq array for each word
        //map<freq.toString, List<words>>
        //return values of map 

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){

            int[] freq = new int[26];

            //populating freq array
            for(char c : strs[i].toCharArray()){

                freq[c - 'a']++;

            }

            String key = Arrays.toString(freq);

            //if map does not have a arrayList for a key, add it in
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}