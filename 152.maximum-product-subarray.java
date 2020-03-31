/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int dpMax;
        int dpMin;

        dpMax = dpMin = nums[0];
        int max = dpMax;
        int preMax = dpMax;
        for (int i = 1; i < nums.length; i++) {
            preMax = dpMax;
            dpMax = Math.max(nums[i], Math.max(dpMax * nums[i], dpMin * nums[i]));
            dpMin = Math.min(nums[i], Math.min(preMax * nums[i], dpMin * nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
}
// @lc code=end

