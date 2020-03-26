/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) { return null; }
        int size = 0;
        HashMap<Node, Integer> nodeIndexHashMap = new HashMap<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            nodeIndexHashMap.put(curr, size);
            size += 1;
        }
        Node[] randomArray = new Node[size];
        Node curr = head;
        for (int i = 0; i < size; i++, curr = curr.next) {
            if (randomArray[i] == null) { randomArray[i] = new Node(curr.val); }
            Node currCpy = randomArray[i];
            Node random = curr.random;
            if (random == null) { continue; }
            int randomIndex = nodeIndexHashMap.get(random);
            if (randomArray[randomIndex] == null) { randomArray[randomIndex] = new Node(random.val); }
            Node randomCpy = randomArray[randomIndex];
            currCpy.random = randomCpy;
        }
        for (int i = 0; i < size - 1; i++) {
            randomArray[i].next = randomArray[i + 1];
        }
        return randomArray[0];
    }
}
// @lc code=end

