/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    boolean[][] dp;
    public int minCut(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) { return 0; }
        dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length() + 1 - len; i++) {
                int j = i + len - 1;
                boolean firstMatch = s.charAt(i) == s.charAt(j);
                if (firstMatch && (len <= 3 || dp[i + 1][j - 1])) { dp[i][j] = true; }
            }
        }

        int[] minCutArray = new int[s.length() + 1];
        for (int i = 0; i < minCutArray.length - 2; i++) { minCutArray[i] = Integer.MAX_VALUE; }
        for (int i = s.length() - 1; i > -1; i--) {
            if (dp[i][s.length() - 1]) { minCutArray[i] = 0; continue; }
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]){
                    minCutArray[i] = Math.min(minCutArray[i], 1 + minCutArray[j + 1]);
                }
            }
        }
        return minCutArray[0];
    }
}
// @lc code=end

