/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0 ; i < n; i++) {
            for (int j = i + 1; j < n; j++) { diagonalSwap(matrix, i, j); }
        }
        for (int i = 0; i < n; i++) { reverseArray(matrix[i]);}
    }
    private void diagonalSwap(int[][] matrix, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private void reverseArray(int[] array) {
        int begin = 0; 
        int end = array.length - 1;
        while (begin < end) {
            swap(array, begin++, end--);
        }
    }
}
// @lc code=end

