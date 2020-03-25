/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) { return null; }
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();
            if (!nodeMap.containsKey(curr.val)) { nodeMap.put(curr.val, new Node(curr.val)); }
            Node currCpy = nodeMap.get(curr.val);

            if (currCpy.neighbors == null) { currCpy.neighbors = new ArrayList<>(); }
            for (Node currAdj : curr.neighbors) {
                if (!nodeMap.containsKey(currAdj.val)) { 
                    nodeMap.put(currAdj.val, new Node(currAdj.val));
                    nodeQueue.offer(currAdj);
                }
                Node currAdjCpy = nodeMap.get(currAdj.val);
                currCpy.neighbors.add(currAdjCpy);
            }
        }
        return nodeMap.get(node.val);
    }
}
// @lc code=end

