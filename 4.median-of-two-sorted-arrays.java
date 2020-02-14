/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int median1 = (l1 + l2 + 1) / 2;
        int median2 = (l1 + l2 + 2) / 2;
        return (getKthElem(nums1, 0, l1-1, nums2, 0, l2-1, median1) + getKthElem(nums1, 0, l1-1, nums2, 0, l2-1, median2)) * 0.5;
    }

    private int getKthElem(int[] nums1, int st1, int end1, int[] nums2, int st2, int end2, int k) {
        int l1 = end1 - st1 + 1;
        int l2 = end2 - st2 + 1;
        if (l1 > l2) { return getKthElem(nums2, st2, end2, nums1, st1, end1, k); }
        if (l1 == 0) { return nums2[st2 + k - 1]; }
        if (k == 1) { return Math.min(nums1[st1], nums2[st2]); }
        int index1 = st1 + Math.min(k/2, l1) - 1;
        int index2 = st2 + Math.min(k/2, l2) - 1;
        if (nums1[index1] < nums2[index2]) {
            return getKthElem(nums1, index1 + 1, end1, nums2, st2, end2, k - (index1 - st1 + 1));
        } else {
            return getKthElem(nums1, st1, end1, nums2, index2+1, end2, k - (index2 - st2 + 1));
        }
    }
}
// @lc code=end

