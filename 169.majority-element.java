/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        for (int bias = 0; bias <= 32; bias++) {
            int sum = 0;
            for (int num : nums) {
                if (((num >> bias) & 1) == 1) {
                    sum++;
                }
            }
            if (sum > nums.length / 2) {
                res |= (1 << bias);
            }
        }
        return res;
    }
}
// @lc code=end

