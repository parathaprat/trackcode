class RandomizedCollection {

    List<Integer> vals;
    Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {

        map = new HashMap<>();
        vals = new ArrayList();
        
    }
    
    public boolean insert(int val) {

        boolean notPresent = !map.containsKey(val);

        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(vals.size());

        vals.add(val);
        return notPresent;

    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)) return false;

        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);

        int lastVal = vals.get(vals.size() - 1);
        vals.set(removeIndex, lastVal);
        vals.remove(vals.size() - 1);

        map.get(lastVal).add(removeIndex);
        map.get(lastVal).remove(vals.size());

        if(map.get(val).isEmpty()) map.remove(val);
        return true;
    }
    
    public int getRandom() {

        int index = (int)(Math.random() * vals.size());
        return vals.get(index);
        
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */