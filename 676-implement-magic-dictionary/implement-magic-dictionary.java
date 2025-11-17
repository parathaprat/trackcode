class MagicDictionary {

    Map<Integer, List<String>> map;

    public MagicDictionary() {

        map = new HashMap<>();
        
    }
    
    public void buildDict(String[] dictionary) {

        for(String word : dictionary){

            if(!map.containsKey(word.length())){
                map.put(word.length(), new ArrayList<>());
            }

            map.get(word.length()).add(word);
        }
        
    }
    
    public boolean search(String searchWord) {

        int len = searchWord.length();

        if(!map.containsKey(len)) return false;

        for(String word : map.get(len)){

            int diff = 0;

            for(int i = 0; i < len; i++){
                if(searchWord.charAt(i) != word.charAt(i)) diff++;

                if(diff > 1) break;
            }

            if(diff == 1) return true;
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */