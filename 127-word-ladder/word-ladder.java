class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //Hashset -> wordList
        //Queue -> BFS
        
        if(beginWord.equals(endWord) || !wordList.contains(endWord)) return 0;

        Set<String> dict = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        int ans = 0;

        while(!q.isEmpty()){

            ans++;

            int level = q.size();

            for(int i = 0; i < level; i++){

                String word = q.poll();

                if(word.equals(endWord)) return ans;

                for(int j = 0; j < word.length(); j++){

                    for(char c = 'a'; c <= 'z'; c++){

                        if(word.charAt(j) == c) continue;

                        String nei = word.substring(0, j) + c + word.substring(j + 1);
                        
                        if(dict.contains(nei)){

                            dict.remove(nei);
                            q.add(nei);
                        }
                    
                    }
                }
            }

        }

        return 0;
    }
}