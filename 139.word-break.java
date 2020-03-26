/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    private List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        return helper(s);
    }
    private boolean helper(String s) {
        if (s == null || s.equals("")) { return true; }
        boolean match = false;
        for (String prefix : wordDict) {
            boolean firstMatch = false;
            if (s.startsWith(prefix)) {
                firstMatch = true;
                firstMatch = firstMatch && helper(s.substring(prefix.length()));
            }
            match = match || firstMatch;
        }
        return match;
    }
}
// @lc code=end

