class OrderedStream {

    int pointer;
    String[] stream;

    public OrderedStream(int n) {

        pointer = 0;
        stream = new String[n];
        
    }
    
    public List<String> insert(int idKey, String value) {

        stream[idKey - 1] = value;

        List<String> res = new ArrayList<>();

        while(pointer < stream.length && stream[pointer] != null){
            res.add(stream[pointer]);
            pointer++;
        }

        return res;
        
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */