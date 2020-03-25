/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int res = gas[i];
            while (res - cost[j] >= 0) {
                res = res - cost[j] + gas[(j + 1) % gas.length];
                j = (j + 1) % gas.length;
                if (j == i) { return i; }
            }
            if (j < i) { return -1; }
            i = j;
        }
        return -1;
    }
}
// @lc code=end

