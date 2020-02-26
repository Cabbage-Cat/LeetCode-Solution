/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for (int x : nums) {
            if (sum < 0) { sum = x; }
            else { sum += x;}
            res = Math.max(res, sum);
        }
        return res;
    }
}
// @lc code=end

