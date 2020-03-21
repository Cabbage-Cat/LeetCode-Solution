/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    class Node implements Comparable<Node> {
        int node;
        int dis;
        public Node(int node, int dis) { this.node = node; this.dis = dis; }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }

    List<Integer>[] graph;
    int[] d;
    int begin, end;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) { return 0; }
        wordList.add(0, beginWord); 
        int l = wordList.size();
        begin = 0;
        graph = new List[l];
        d = new int[l];
        for (int i = 0; i < l; i++) {
            if (wordList.get(i).equals(endWord)) { end = i; }
            graph[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                String x = wordList.get(i);
                String y = wordList.get(j);
                int diff = 0;
                for (int k = 0; k < x.length(); k++) {
                    if (x.charAt(k) != y.charAt(k)) { diff++; }
                    if (diff >= 2) { break; }
                }
                if (diff == 1) { graph[i].add(j); graph[j].add(i); }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        d[0] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.node;
            int dis = node.dis;
            for (int v : graph[u]) {
                if (dis + 1 < d[v]) {
                    d[v] = dis + 1;
                    pq.offer(new Node(v, dis + 1));
                }
            }
        }
        return d[end] == Integer.MAX_VALUE? 0 : d[end] + 1;
    }
}
// @lc code=end

