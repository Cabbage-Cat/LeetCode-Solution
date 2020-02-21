/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return numberLessThan(nums, target, 0, nums.length - 1);
    }
    private int numberLessThan(int[] nums, int target, int l, int r) {
        if (l > r || l < 0 || r > nums.length - 1) { return 0; }
        int mid = (l + r) / 2;
        int midNumber = nums[mid];
        if (midNumber < target && (mid == nums.length - 1 || nums[mid + 1] >= target)) { return mid + 1; }
        else if (midNumber < target) { return numberLessThan(nums, target, mid + 1, r); }
        else { return numberLessThan(nums, target, l, mid - 1); }
    }
}
// @lc code=end

