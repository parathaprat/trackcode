class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord) || beginWord.equals(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int steps = 1;
        while(!q.isEmpty()){

            int level = q.size();

            for(int i = 0; i < level; i++){

                String word = q.poll();
                if(word.equals(endWord)) return steps;

                for(int j = 0; j < word.length(); j++){

                    for(char c = 'a'; c <= 'z'; c++){

                        if(c == word.charAt(j)) continue;
                        String nei = word.substring(0, j) + c + word.substring(j + 1);

                        if(set.contains(nei)){
                            q.add(nei);
                            set.remove(nei);
                        }
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}