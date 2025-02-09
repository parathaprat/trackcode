class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        //BFS to find the shortest path
        Set<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();

        //add starting word to q
        q.add(beginWord);

        int res = 0;

        while(!q.isEmpty()){

            //increment res at each iteration
            res++;

            for(int i = q.size(); i > 0; i--){

                //get top node, check if it is the end
                String node = q.poll();
                if(node.equals(endWord)) return res;

                for(int j = 0; j < node.length(); j++){
                    
                    for(char c = 'a'; c <= 'z'; c++){

                        if(c == node.charAt(j)) continue;

                        //append letter from a to z at every single position and check if it is in the set
                        String nei = node.substring(0, j) + c + node.substring(j + 1);

                        //if the set has a potencial nei, add nei to queue
                        if(set.contains(nei)){
                            q.offer(nei);
                            set.remove(nei);

                        }
                    }
                }
            }
        }

        return 0;


    }
}