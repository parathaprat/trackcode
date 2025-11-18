class RandomizedSet {

    List<Integer> values;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        values = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        map.put(val, values.size());
        values.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {

        //copy last element to index of val, pop last
        
        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        map.put(values.get(values.size() - 1), index);
        map.remove(val);

        values.set(index, values.get(values.size() - 1));
        values.remove(values.size() - 1);

        return true;
        
    }
    
    public int getRandom() {

        int index = (int)(Math.random() * values.size());

        return values.get(index);

        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */