class TimeMap {

    class Pair{
        int timestamp;
        String val;

        Pair(int timestamp, String val){
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    HashMap<String, ArrayList<Pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(hashMap.containsKey(key)){
            hashMap.get(key).add(new Pair(timestamp, value));
        }
        else{
            ArrayList<Pair> pair = new ArrayList<>();
            pair.add(new Pair(timestamp, value));
            hashMap.put(key, pair);
        }
    }
    
    public String get(String key, int timestamp) {
        
        String cand= "";

        if(hashMap.containsKey(key)) {
            ArrayList<Pair> arr = hashMap.get(key);
            int low = 0;
            int high = arr.size() - 1;

            while(low <= high){

                int mid = low + (high - low)/2;

                int timeVal = arr.get(mid).timestamp;

                if(timeVal == timestamp){
                    return arr.get(mid).val;
                }
                else if(timeVal < timestamp){
                    cand = arr.get(mid).val;
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }

        return cand;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */