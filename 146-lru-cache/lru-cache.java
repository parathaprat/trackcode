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

    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

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
        if(map.size() == capacity) remove(tail.prev);

        insert(new Node(key, value));
        
    }

    public void insert(Node node){

        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev = head;

        map.put(node.key, node);
    }

    public void remove(Node node){

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