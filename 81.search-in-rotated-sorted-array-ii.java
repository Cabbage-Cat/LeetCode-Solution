/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return false; }
        return search(nums, 0, nums.length - 1, target) != -1;
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r || r >= nums.length || l < 0) { return -1; }
        int mid = (l + r) / 2;
        int midNumber = nums[mid];
        if (midNumber == target) { return mid; }
        while (l < mid && nums[l] == midNumber) { l++; }
        while (r > mid && nums[r] == midNumber) { r--; }
        if (midNumber < nums[l]) {
            if (mid + 1 <= r && nums[mid + 1] <= target && nums[r] >= target) { return search(nums, mid + 1, r, target); }
            else { return search(nums, l, mid - 1, target); }
        } else {
            if (mid - 1 >= l && nums[mid - 1] >= target && nums[l] <= target) { return search(nums, l, mid - 1, target); }
            else { return search(nums, mid + 1, r, target); }
        }
    }
}
// @lc code=end

