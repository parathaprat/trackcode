class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> set = new HashSet<>();

        for(String word : wordList){

            set.add(word);
        }

        //loop through each letter of beginWord
        //replace with each letter of the alphabet
        //check if this new word is in our wordList
        //return min

        int ans = 0;

        //queue to do BFS -> to find shortest path
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){

            ans++;

            int level = q.size();

            for(int j = 0; j < level; j++){

                String word = q.poll();

                if(word.equals(endWord)) return ans;

                for(int i = 0; i < word.length(); i++){

                    for(char c = 'a'; c <= 'z'; c++){

                        if(c == word.charAt(i)) continue;

                        String nei = word.substring(0, i) + c + word.substring(i + 1);
                        if(set.contains(nei)){
                            set.remove(nei);
                            q.add(nei);
                        }

                    }


                }
            }
        }

        return 0;

    }
}