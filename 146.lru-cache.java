/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUList{
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }
    Node guard;
    HashMap<Integer, Node> nodeHashMap;
    int size;
    public LRUList() {
        this.nodeHashMap = new HashMap<>();
        this.guard = new Node(-1, -1);
        guard.prev = guard;
        guard.next = guard;
        size = 0;
    }
    Node get(int key) {
        return nodeHashMap.getOrDefault(key, null);
    }
    void moveToEnd(Node node) {
        Node last = guard.prev;
        if (node == last) { return; }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        last.next = node;
        node.prev = last;
        node.next = guard;
        guard.prev = node;
    }
    void deleteFirst() {
        Integer key = guard.next.key;
        guard.next = guard.next.next;
        guard.next.prev = guard;
        size--;
        nodeHashMap.remove(key);
    }
    void put(int key, int value) {
        Node curr = get(key);
        if (curr == null) {
            curr = new Node(key, value);
            Node last = guard.prev;
            last.next = curr;
            curr.prev = last;
            curr.next = guard;
            guard.prev = curr;
            size++;
        } else {
            curr.value = value;
            moveToEnd(curr);
        }
        nodeHashMap.put(key, curr);
    }
}
class LRUCache {
    private int capacity;
    private LRUList list;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LRUList();
    }

    public int get(int key) {
        LRUList.Node node = list.get(key);
        if (node == null) {
            return -1;
        }
        list.moveToEnd(node);
        return node.value;
    }

    public void put(int key, int value) {
        list.put(key, value);
        if (list.size > capacity) { list.deleteFirst(); }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

