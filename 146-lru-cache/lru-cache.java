class LRUCache {

    //DLL = key, val, next, prev
    //map = key, node

    class Node{

        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.val; 
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }

        insert(new Node(key, value));
        
    }

    private void insert(Node node){

        map.put(node.key, node);

        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    private void remove(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */