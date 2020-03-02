/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) { return; }
        mySort(nums, 0, nums.length - 1);
    }
    private static void mySort(int[] nums, int begin, int end) {
        if (begin >= end) { return; }
        int left = begin, i = begin + 1, right = end;
        int v = nums[left];
        while (i <= right) {
            int cmp = nums[i] - v;
            if (cmp < 0) { swap(nums, i++, left++); }
            else if (cmp > 0) { swap(nums, i, right--); }
            else { i++; }
        }
        mySort(nums, begin, left - 1);
        mySort(nums, right + 1, end);
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

