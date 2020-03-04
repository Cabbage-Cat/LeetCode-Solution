/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) { return 0; }
        int[] leftMinIndex = new int[heights.length];
        int[] rightMinIndex = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int index = i - 1;
            while (index > -1 && heights[index] >= h) { index = leftMinIndex[index]; }
            leftMinIndex[i] = index;
        }

        for (int i = heights.length - 1; i > -1 ; i--) {
            int h = heights[i];
            int index = i + 1;
            while (index < heights.length && heights[index] >= h) { index = rightMinIndex[index]; }
            rightMinIndex[i] = index;
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int width = rightMinIndex[i] - leftMinIndex[i] - 1;
            int tmp = h * width;
            res = Math.max(tmp ,res);
        }
        return res;
    }
}
// @lc code=end

