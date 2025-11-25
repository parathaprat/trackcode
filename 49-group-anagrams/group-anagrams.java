class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        //populate map (common freq -> list of anagrams)
        for(String str : strs){

            int[] freq = new int[26];
            
            for(char c : str.toCharArray()){
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        for(List<String> vals : map.values()){
            res.add(vals);
        }

        return res;
        
    }
}