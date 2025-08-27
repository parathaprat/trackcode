class LRUCache {

    class Node{

        int key;
        int val;

        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){

            Node node = map.get(key);
            remove(node);
            insert(node);

            return map.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){

            Node toRemove = map.get(key);
            remove(toRemove);

            Node node = new Node(key, value);
            insert(node);
        }
        else{

            if(capacity == map.size()){
                remove(tail.prev);
            }

            Node node = new Node(key, value);
            insert(node);
        }
    }

    public void remove(Node node){

        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void insert(Node node){

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;

        map.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */