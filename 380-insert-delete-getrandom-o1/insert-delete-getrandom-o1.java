class RandomizedSet {

    List<Integer> vals;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        vals = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        map.put(val, vals.size());
        vals.add(val);

        return true;
        
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        int last = vals.get(vals.size() - 1);

        map.put(last, index);
        map.remove(val);

        vals.set(index, last);
        vals.remove(vals.size() - 1);

        return true;   
    }
    
    public int getRandom() {

        int index = (int)(Math.random() * vals.size());
        return vals.get(index);

        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */