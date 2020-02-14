/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.equals("")) { return ""; }
        String origin = s;
        String reverse = new StringBuffer(origin).reverse().toString();
        int l = origin.length();
        int maxIndex = 0;
        int maxLength = 0;
        int[][] dp = new int[l][l];

        for (int i=0; i<l; i++) {
            for (int j=0; j<l; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i==0 || j==0) { dp[i][j] = 1; }
                    else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                if (dp[i][j] > maxLength) {
                    int before = l - 1 - j;
                    if (before + dp[i][j] - 1 == i) {
                        maxLength = dp[i][j];
                        maxIndex = i;
                    }
                    
                }
            }
        }
        return s.substring(maxIndex - maxLength + 1, maxIndex + 1);
        
    }
}
// @lc code=end

