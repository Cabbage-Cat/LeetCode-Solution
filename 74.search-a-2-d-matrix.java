/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) { return false; }
        int row = findRow(matrix,0, matrix.length - 1, target);
        int[] array = matrix[row];
        int targetIndex = findTarget(array, 0, array.length - 1, target);
        return array[targetIndex] == target;
    }

    private int findRow(int[][] matrix, int begin, int end, int target) {
        if (begin >= end) { return begin; }
        int mid = (begin + end) / 2;
        int num = matrix[mid][0];
        if (num == target || (num < target && matrix[mid+1][0] > target)) { return mid; }
        else if (num < target) { return findRow(matrix, mid + 1, end, target); }
        else { return findRow(matrix, begin, mid - 1, target); }
    }
    private int findTarget(int[] array, int begin, int end, int target) {
        if (begin >= end) { return begin; }
        int mid = (begin + end) / 2;
        int num = array[mid];
        if (num == target) { return mid; }
        else if (num < target) { return findTarget(array, mid + 1, end, target); }
        else { return findTarget(array, begin, mid - 1, target); }
    }
}
// @lc code=end

