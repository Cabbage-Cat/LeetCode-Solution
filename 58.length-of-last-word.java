/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) { return 0; }
        s = s.trim();
        int l = s.length() - 1;
        int i = l;
        for (; i > -1; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return l - i;
    }
}
// @lc code=end

