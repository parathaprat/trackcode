class Solution {
    public int maximumLength(String s) {
        
        //use map to keep track of substrings and frequencies
        Map<String, Integer> map = new HashMap<>();

        //filling up hashmap
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){

                String str = s.substring(i, j);

                //if map contains substring value pair, add 1 to value
                if(map.containsKey(str)){
                    map.put(str, map.get(str) + 1);
                }
                else{
                    map.put(str, 1);
                }
            }
        }

        //main logic
        int len = 0;

        //going through each entry in map
        for(Map.Entry<String, Integer> entry : map.entrySet()){

            //getting key value pair
            String str = entry.getKey();
            int stringCount = entry.getValue();

            //since special substring occuers atleast thrice
            if(stringCount >= 3){

                //creating set to make sure chars are equal (speacial substring is made from only 1 char)
                Set<Character> set = new HashSet<>();

                for(int i = 0; i < str.length(); i++){
                    set.add(str.charAt(i));
                }

                if(set.size() == 1) {
                    len = Math.max(len, str.length());
                }
            }
        }

        return len == 0 ? -1 : len;
    }
}