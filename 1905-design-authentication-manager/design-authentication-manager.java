class AuthenticationManager {

    HashMap<String, Integer> map; //token, currentTime
    int ttl;

    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        ttl = timeToLive;
        
    }
    
    public void generate(String tokenId, int currentTime) {

        map.put(tokenId, currentTime);
        
    }
    
    public void renew(String tokenId, int currentTime) {

        //check if ttl hasnt been hit first
        if(map.containsKey(tokenId) && currentTime - map.get(tokenId) < ttl){
            map.put(tokenId, currentTime);
        }
        
    }
    
    public int countUnexpiredTokens(int currentTime) {

        int count = 0;

        HashMap<String, Integer> temp = new HashMap<>(map); //duplicate map since same map cannot be modified

        for(Map.Entry<String, Integer> e : temp.entrySet()){

            if(currentTime - e.getValue() < ttl){
                count++;
            }
            else{
                map.remove(e.getKey());
            }
        }

        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */