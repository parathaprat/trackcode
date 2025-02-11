class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        int ans = 0;

        //BFS -> the shortest path -> Set(wordList), queue to iterate 

        Set<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while(!q.isEmpty()){

            ans++;

            int level = q.size();

            for(int i = 0; i < level; i++){

                String word = q.poll();

                if(word.equals(endWord)) return ans;

                for(int j = 0; j < word.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){

                        //skip cus this will be in the set
                        if(c == word.charAt(j)) continue;

                        String nei = word.substring(0, j) + c + word.substring(j + 1);

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