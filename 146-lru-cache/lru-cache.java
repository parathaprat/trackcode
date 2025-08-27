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

    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

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

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        else{
            if(map.size() == capacity){
                remove(tail.prev);
            }
        }

        insert(new Node(key, value));
    }

    public void remove(Node node){

        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){

        map.put(node.key, node);

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node. prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */