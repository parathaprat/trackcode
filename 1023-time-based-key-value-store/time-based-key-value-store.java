class TimeMap {

    class pair{

        int timestamp;
        String val;

        pair(int timestamp, String val){
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    HashMap<String, ArrayList<pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hashMap.containsKey(key)){
            hashMap.get(key).add(new pair(timestamp, value));
        }
        else{
            ArrayList<pair> arr = new ArrayList<>();
            arr.add(new pair(timestamp, value));
            hashMap.put(key, arr);
        }
    }
    
    public String get(String key, int timestamp) {
        
        String ans = "";

        if(hashMap.containsKey(key)){

            ArrayList<pair> arr = hashMap.get(key);

            int l = 0;
            int r = arr.size() - 1;

            while(l <= r){

                int m = l + (r - l)/2;

                int timeVal = arr.get(m).timestamp;

                if(timeVal == timestamp){
                    return arr.get(m).val;
                }
                else if(timeVal < timestamp){
                    ans = arr.get(m).val;
                    l = m + 1;
                }
                else{
                    r = m - 1;
                }
            }
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */