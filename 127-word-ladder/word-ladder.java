class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.equals(endWord) || !wordList.contains(endWord)) return 0;
        
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        int steps = 1;

        while(!q.isEmpty()){
            
            int level = q.size();

            for(int i = 0; i < level; i++){

                String cur = q.poll();
                if(cur.equals(endWord)) return steps;

                for(int j = 0; j < cur.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        
                        if(c == cur.charAt(j)) continue;

                        String nei = cur.substring(0, j) + c + cur.substring(j + 1);
                        
                        if(dict.contains(nei)){
                            q.offer(nei);
                            dict.remove(nei);

                        } 
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}