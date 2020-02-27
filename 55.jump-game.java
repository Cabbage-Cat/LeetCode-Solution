/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length && end >= i; i++) {
            end = Math.max(i + nums[i], end);
        }
        return end >= nums.length - 1;
    }
}
// @lc code=end

