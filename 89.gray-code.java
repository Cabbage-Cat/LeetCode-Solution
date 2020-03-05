/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int binary = 0; binary < 1 << n; binary++) {
            res.add(binary ^ binary >> 1);
        }
        return res;
    }
}
// @lc code=end

