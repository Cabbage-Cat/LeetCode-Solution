/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) { return 0; }
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) { heights[i][j] = matrix[i][j] == '1' ? 1 : 0; }
                else {
                    if (matrix[i][j] == '0') { heights[i][j] = 0; }
                    else { heights[i][j] = heights[i-1][j] + 1;}
                }
            }
        }
        int res = 0;
        for (int[] h : heights) { res = Math.max(res, findMaxRectangle(h)); }
        return res;
    }
    private int findMaxRectangle(int[] height) {
        int[] leftMinIndex = new int[height.length];
        int[] rightMinIndex = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            int index = i - 1;
            while (index > -1 && height[index] >= h) { index = leftMinIndex[index]; }
            leftMinIndex[i] = index;
        }

        for (int i = height.length - 1; i > -1; i--) {
            int h = height[i];
            int index = i + 1;
            while (index < height.length && height[index] >= h) { index = rightMinIndex[index]; }
            rightMinIndex[i] = index;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            int width = rightMinIndex[i] - leftMinIndex[i] - 1;
            int tmp = h * width;
            res = Math.max(tmp ,res);
        }
        return res;
    }
}
// @lc code=end

