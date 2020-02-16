/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) { return sb.toString(); }
        for (int i = 0; ; i++) {
            int c = -1;
            for (String s : strs) {
                if (!(i < s.length()) || s.equals("")) { return sb.toString(); }
                if (c == -1) {
                    c = s.charAt(i);
                } else {
                    if (c != s.charAt(i)) { return sb.toString(); }
                }
            }
            sb.append((char)c);
        }
    }
}
// @lc code=end

