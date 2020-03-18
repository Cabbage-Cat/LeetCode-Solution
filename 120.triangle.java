/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 0; row < triangle.size(); row++) {
            for (int i = 0; i < triangle.get(row).size(); i++) {
                if (row > 0) {
                    int base = triangle.get(row).get(i);
                    int tmp = Integer.MAX_VALUE;
                    if (i > 0) { tmp = Math.min(tmp, triangle.get(row - 1).get(i - 1)); }
                    if (i < row) { tmp = Math.min(tmp, triangle.get(row - 1).get(i)); }
                    // if (i < row - 1) { tmp = Math.min(tmp, triangle.get(row - 1).get(i + 1)); }
                    triangle.get(row).set(i, base + tmp);
                }
            }
        }

        List<Integer> lst = triangle.get(triangle.size() - 1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < lst.size(); i++) {
            res = Math.min(lst.get(i), res);
        }
        return res;
    }
}
// @lc code=end

