/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int begin, int end) {
        if (begin == end) { return begin; }
        int mid = (begin + end) / 2;
        if (nums[mid] > nums[mid + 1]) { return helper(nums, begin, mid); }
        else { return helper(nums, mid + 1, end); }
    }
}
// @lc code=end

