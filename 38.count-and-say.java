/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) { return "1"; }
        else {
            String last = countAndSay(n - 1);
            return helper(last);
        }
    }
    private String helper(String s) {
        // 1211 -> 111221
        if (s == null || s.length() == 0) { return ""; }
        int cnt = getDuplicate(s, 0);
        return String.valueOf(cnt) + s.charAt(0) + helper(s.substring(cnt));
    }
    private int getDuplicate(String s, int i) {
        int j = i;
        char c = s.charAt(i++);
        while (i < s.length() && s.charAt(i) == c) { i++; }
        return i - j;
    }
}
// @lc code=end

