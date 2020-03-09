/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != s3.length()) { return false; }
        boolean[] dp = new boolean[l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) { dp[j] = true; }
                else if (i == 0) { dp[j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[j-1]; }
                else if (j == 0) { dp[j] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[j]; }
                else {
                    int k = i + j - 1;
                    boolean firstMatch = s1.charAt(i - 1) == s3.charAt(k) && dp[j];
                    boolean secondMatch = s2.charAt(j - 1) == s3.charAt(k) && dp[j-1];
                    dp[j] = firstMatch || secondMatch;
                }
            }
        }
        return dp[l2];

    }
}
// @lc code=end

