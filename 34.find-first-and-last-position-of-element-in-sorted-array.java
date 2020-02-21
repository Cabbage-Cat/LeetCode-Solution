/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums, target, 0, nums.length - 1);
        res[1] = findRight(nums, target, 0, nums.length - 1);
        return res;
    }


    private int findLeft(int[] nums, int target, int l, int r) {
        if (l > r || l < 0 || r > nums.length - 1) { return -1; }
        int mid = (l + r) / 2;
        int midNumber = nums[mid];
        if (midNumber == target && (mid == 0 || nums[mid - 1] != midNumber)) { return mid; }
        else if (midNumber < target) { return findLeft(nums, target, mid + 1, r); }
        else { return findLeft(nums, target, l, mid - 1); }
    }

    private int findRight(int[] nums, int target, int l, int r) {
        if (l > r || l < 0 || r > nums.length - 1) { return -1; }
        int mid = (l + r) / 2;
        int midNumber = nums[mid];
        if (midNumber == target && (mid == nums.length - 1 || nums[mid + 1] != midNumber)) { return mid; }
        else if (midNumber > target) { return findRight(nums, target, l, mid - 1); }
        else { return findRight(nums, target, mid + 1, r); }
    }
}
// @lc code=end

