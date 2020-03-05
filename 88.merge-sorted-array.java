/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0 || n == 0) { return; }
        int index = m + n - 1;
        int nums1Cmp = m - 1;
        int nums2Cmp = n - 1;

        while (nums1Cmp > -1 && nums2Cmp > -1) {
            int num1 = nums1[nums1Cmp];
            int num2 = nums2[nums2Cmp];
            if (num1 < num2) { nums1[index--] = nums2[nums2Cmp--]; }
            else { nums1[index--] = nums1[nums1Cmp--]; }
        }
        while (nums2Cmp > -1) { nums1[index--] = nums2[nums2Cmp--]; }
    }
}
// @lc code=end

