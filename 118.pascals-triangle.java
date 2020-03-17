/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            int index = 0;
            tmp.add(index++, 1);
            for (; index < i - 1; index++) {
                List<Integer> lastList = res.get(i - 2);
                int t = lastList.get(index - 1) + lastList.get(index);
                tmp.add(t);
            }
            if (i > 1) { tmp.add(1); }
            res.add(tmp);
        }
        return res;
    }
}
// @lc code=end

