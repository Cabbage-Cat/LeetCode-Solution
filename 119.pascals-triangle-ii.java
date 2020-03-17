/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        int[] array = new int[rowIndex];
        array[0] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 2; j > 0; j--) { array[j] = array[j] + array[j - 1]; }
            array[i - 1] = 1;
        }
        List<Integer> res = new ArrayList<>(rowIndex);
        for (int x : array) { res.add(x); }
        return res;
    }
}
// @lc code=end

