/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int [] nums, int target, int l, int r) {
        if (l > r || l < 0 || r > nums.length - 1) { return -1; }
        int mid = (l + r) / 2;
        int midNumber = nums[mid];
        if (midNumber == target) { return mid; }

        if (midNumber < nums[l]) {
            if (mid + 1 <= r && nums[mid + 1] <= target && nums[r] >= target) { return search(nums, target, mid + 1, r); }
            else { return search(nums, target, l, mid - 1); }
        } else {
            if (mid - 1 >= l && nums[mid - 1] >= target && nums[l] <= target) { return search(nums, target, l, mid - 1); }
            else { return search(nums, target, mid + 1, r); }
        }
    }
}
// @lc code=end

