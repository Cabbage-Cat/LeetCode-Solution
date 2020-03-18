/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    int[] prices;
    private class Pair implements Comparable<Pair> {
        int beginIndex;
        int endIndex;
        public Pair(int x, int y) {
            beginIndex = x;
            endIndex = y;
        }
        @Override
        public int compareTo(Pair other) {
            int thisProfit = prices[endIndex] - prices[beginIndex];
            int otherProfit = prices[other.endIndex] - prices[other.beginIndex];
            return otherProfit - thisProfit;
        }
    }
    public int maxProfit(int[] prices) {
        this.prices = prices;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int slow = 0, fast = 1;
        for (; fast < prices.length; fast++) {
            if (prices[fast] > prices[fast - 1]) { continue; }
            else {
                int endIndex = fast - 1;
                if (slow != endIndex) {
                    Pair p = new Pair(slow, endIndex);
                    pq.offer(p);
                }
                slow = fast;
            }
        }
        if (fast - 1 != slow && prices[fast - 1] - prices[slow] > 0) {
            pq.offer(new Pair(slow, fast - 1));
        }
        int profit = 0;
        if (pq.size() == 0) { }
        else if (pq.size() == 1) {
            Pair p = pq.poll();
            profit += prices[p.endIndex] - prices[p.beginIndex];
        } else {
            Pair p = pq.poll();
            Pair q = pq.poll();
            profit += prices[p.endIndex] - prices[p.beginIndex];
            profit += prices[q.endIndex] - prices[q.beginIndex];
        }
        return profit;
    }
}
// @lc code=end

