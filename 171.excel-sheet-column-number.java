/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for (char c : charArray) {
            int bias = c - 'A' + 1;
            res = res * 26 + bias;
        }
        return res;
    }
}
// @lc code=end

