/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
            int j = height.length - i - 1;
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
        }

        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            int h = height[i];
            res = minHeight > h ? res + minHeight - h : res;
        }
        return res;
    }
}
// @lc code=end

